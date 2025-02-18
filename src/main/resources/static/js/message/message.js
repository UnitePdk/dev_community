/**
 * 메시지 시스템 JavaScript 코드
 * 쪽지의 조회, 삭제 등 모든 기능을 제공합니다.
 * 작성일: 2024-02-18
 */

// ================ 상수 및 설정 ================
const API_ENDPOINTS = {
  GET_USER: "/mno.do",
  RECEIVED_MESSAGES: "/message/receive/find.do",
  SENT_MESSAGES: "/message/send/find.do",
  DELETE_RECEIVED: "/message/receiver/delete.do",
  DELETE_SENT: "/message/send/delete.do",
};

const FETCH_CONFIG = {
  GET: {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      "Cache-Control": "no-cache",
    },
    credentials: "include",
  },
  DELETE: {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      "Cache-Control": "no-cache",
    },
    credentials: "include",
  },
};

// ================ 유틸리티 함수 ================
const getCurrentUserMno = async () => {
  try {
    console.log("사용자 정보 조회 시작");
    const response = await fetch(API_ENDPOINTS.GET_USER);
    if (!response.ok) throw new Error(`사용자 정보 조회 실패: ${response.status}`);

    const mno = await response.json();
    if (!mno || mno === 0) throw new Error("로그인이 필요합니다.");
    return mno;
  } catch (error) {
    console.error("사용자 정보 조회 실패:", error);
    throw error;
  }
};

const escapeHtml = (unsafe) => {
  if (!unsafe) return "";
  return unsafe
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;")
    .replace(/'/g, "&#039;");
};

/**
 * HTML 태그 제거 (HTML을 텍스트로 변환)
 * @param {string} html 태그를 포함한 문자열
 * @returns {string} 태그가 제거된 문자열
 */
const stripHtml = (html) => {
  if (!html) return "";
  const doc = new DOMParser().parseFromString(html, "text/html");
  return doc.body.textContent || "";
};

const formatDate = (dateString) => {
  if (!dateString) return "";
  try {
    const date = new Date(dateString);
    if (isNaN(date.getTime())) return dateString;
    return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, "0")}-${String(date.getDate()).padStart(
      2,
      "0"
    )} ${String(date.getHours()).padStart(2, "0")}:${String(date.getMinutes()).padStart(2, "0")}:${String(
      date.getSeconds()
    ).padStart(2, "0")}`;
  } catch (error) {
    console.error("날짜 파싱 오류:", error);
    return dateString;
  }
};

// ================ API 호출 함수 ================
const fetchData = async (url, config = FETCH_CONFIG.GET) => {
  try {
    console.log("API 요청:", url);
    const response = await fetch(url, config);
    if (!response.ok) throw new Error(`HTTP 오류 ${response.status}`);

    return await response.json();
  } catch (error) {
    console.error("API 요청 실패:", error);
    throw error;
  }
};

const loadAllMessages = async (page = 1) => {
  try {
    console.log(`전체 메시지 로드 - 페이지: ${page}`);
    const mno = await getCurrentUserMno();
    const [receivedData, sentData] = await Promise.all([
      fetchData(`${API_ENDPOINTS.RECEIVED_MESSAGES}?receivermno=${mno}&page=${page}`),
      fetchData(`${API_ENDPOINTS.SENT_MESSAGES}?sendermno=${mno}&page=${page}`),
    ]);

    const receivedMessages = Array.isArray(receivedData) ? receivedData : receivedData.list || [];
    const sentMessages = Array.isArray(sentData) ? sentData : sentData.list || [];

    const allMessages = [
      ...receivedMessages.map((msg) => ({ ...msg, type: "received" })),
      ...sentMessages.map((msg) => ({ ...msg, type: "sent" })),
    ].sort((a, b) => new Date(b.medate) - new Date(a.medate));

    displayAllMessages(allMessages);
  } catch (error) {
    console.error("메시지 로드 실패:", error);
    alert(error.message || "메시지 목록을 불러오는 데 실패했습니다.");
  }
};

// ================ UI 관련 함수 ================
const displayAllMessages = (messages) => {
  const tbody = document.getElementById("allMessages");
  if (!tbody) return;

  tbody.innerHTML =
    messages.length === 0
      ? '<tr><td colspan="5" class="text-center">메시지가 없습니다.</td></tr>'
      : messages.map(createAllMessageRow).join("");
};

const createAllMessageRow = (message) => {
  const isReceived = message.type === "received";
  const userColumn = isReceived ? message.sendmid : message.receivermid;
  const messageType = isReceived ? "받은 쪽지" : "보낸 쪽지";
  const deleteFunction = isReceived ? "confirmDeleteReceivedMessage" : "confirmDeleteSentMessage";

  // HTML 태그 제거 후 출력
  const previewContent = stripHtml(message.mecontent).substring(0, 100) + "...";

  return `
    <tr>
      <td>${escapeHtml(message.metitle)}</td>
      <td>${escapeHtml(userColumn)}</td>
      <td>${messageType}</td>
      <td>${formatDate(message.medate)}</td>
      <td>${escapeHtml(previewContent)}</td>
      <td>
        <button class="btn btn-danger btn-sm" onclick="${deleteFunction}(${message.meno})">삭제</button>
      </td>
    </tr>
  `;
};

// ================ 삭제 관련 함수 ================
const deleteMessage = async (type, meno) => {
  try {
    const mno = await getCurrentUserMno();
    const endpoint = type === "received" ? API_ENDPOINTS.DELETE_RECEIVED : API_ENDPOINTS.DELETE_SENT;
    const url = `${endpoint}?meno=${meno}&mno=${mno}`;

    const response = await fetch(url, FETCH_CONFIG.DELETE);
    if (!response.ok) throw new Error(`삭제 실패: ${response.status}`);

    alert("쪽지가 삭제되었습니다.");
    window.location.reload();
  } catch (error) {
    console.error("쪽지 삭제 실패:", error);
    alert("삭제 중 오류 발생: " + error.message);
  }
};

const confirmDeleteMessage = (type, meno) => {
  if (confirm("정말 삭제하시겠습니까?")) deleteMessage(type, meno);
};

// 전역 함수 등록
window.loadPage = (page) => loadAllMessages(page);
window.confirmDeleteReceivedMessage = (meno) => confirmDeleteMessage("received", meno);
window.confirmDeleteSentMessage = (meno) => confirmDeleteMessage("sent", meno);

// ================ 초기화 ================
document.addEventListener("DOMContentLoaded", () => {
  loadAllMessages(1);
});
