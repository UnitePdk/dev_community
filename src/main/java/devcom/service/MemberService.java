package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.entity.MemberEntity;
import devcom.model.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;
    @Autowired private FileService fileService;
    @Autowired private HttpServletRequest httpServletRequest; // 세션 객체 호출

    // 세션 함수
    // (1) 세션에 객체 정보 추가
    public boolean setSession(String mid){
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("loginId", mid);
        return true;
    }

    // (2) 세션 객체 내 정보 반환
    public String getSession(){
        HttpSession httpSession = httpServletRequest.getSession();
        // 세션 객체 속성명 값 가져오기
        Object object = httpSession.getAttribute("loginId");
        if (object != null){
            String mid = (String)object;
            return mid;
        }
        return null;
    }

    // (3) 세션 내 객체 정보 삭제
    public boolean deleteSession(){
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.removeAttribute("loginId");
        return true;
    }

    // 회원가입
    @Transactional
    public boolean signup(MemberDto memberDto){
        if ((memberDto.getUploadfile() == null || memberDto.getUploadfile().isEmpty())){ // null 체크로 nullPointException 방지
            memberDto.setMimg("default.jpg");
        } else {
            String fileName = fileService.fileUpload(memberDto.getUploadfile());
            if (fileName == null){return false;}
            else {
                memberDto.setMimg(fileName);
            }
        }
        // 엔티티 변환
        MemberEntity memberEntity = memberDto.toEntity();
        // 엔티티 저장
        MemberEntity saveEntity = memberRepository.save(memberEntity);
        return saveEntity.getMno() > 0;
    }

    // 로그인
    public boolean login(@RequestBody MemberDto memberDto){
        boolean result = memberRepository.existsByMidAndMpwd(memberDto.getMid(), memberDto.getMpwd());
        if (result == true){
            System.out.println("로그인 성공");
            setSession(memberDto.getMid());
            return true;
        }
        else {
            System.out.println("로그인 실패");
            return false;
        }
    }

    // 로그인 된 회원 정보 조회
    public MemberDto info(){
        String mid = getSession();
        if (mid != null){
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            MemberDto memberDto = memberEntity.toDto();
            return memberDto;
        }
        return null;
    }

    // 로그인 된 회원 탈퇴
    public boolean delete(){
        String mid = getSession();
        if (mid != null){
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            // 외래 키로 참조하는 엔티티 관계 제거 예정
            memberRepository.delete(memberEntity);
            deleteSession();
            return true;
        }
        return false;
    }

    // 로그인 된 회원 정보 수정
    public boolean update(@RequestBody MemberDto memberDto){
        String mid = getSession();
        if (mid != null){
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            memberEntity.setMname(memberDto.getMname());
            memberEntity.setMemail(memberDto.getMemail());
            return true;
        }
        return false;
    }

}
