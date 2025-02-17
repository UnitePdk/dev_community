package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.dto.MessageDto;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.MessageEntity;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MessageService {
    @Autowired MessageRepository messageRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    // [1] 메세지 보내기
    public boolean send(MessageDto messageDto) {
        try{
            // 추가
            int mno=0;
            if(memberService.getSession()!=null) {
                mno = memberRepository.findByMid(memberService.getSession()).getMno();
            }
//            MemberEntity loginEntity = memberRepository.findById( mno ).get();

            // 2. messageDto entity 변환
            MessageEntity messageEntity = messageDto.toEntity();

            // 3. 로그인된 회원을 발신자로 설정
            MemberEntity sendEntity = memberRepository.findById(mno).get();
            messageEntity.setSendermno(sendEntity);

            // 4. 수신자 존재 여부 확인 및 설정
            Optional<MemberEntity> optionalReceiver = memberRepository.findById(messageDto.getReceivermno());
            if(!optionalReceiver.isPresent()) {
                System.out.println("메세지 전송 실패: 수신자가 존재하지 않음");
                return false;
            }
            messageEntity.setReceivermno(optionalReceiver.get());

            // 5. 메세지 저장
            messageRepository.save(messageEntity);
            System.out.println("메세지 전송 성공");
            return true;

            } catch (Exception e) {
            System.out.println("메세지 전송실패: " + e);
            return false;
        }
    }

    // [2] 받은 메세지 조회 추가 해야하는거: 삭제된 메세지 필터링
    @Transactional(readOnly = true)
    public List<MessageDto> FindReceiverMessage(int mno) {
        // 추가
        // 1. 로그인 상태 확인
        MemberDto loginDto = memberService.info();
        if(loginDto == null || loginDto.getMno() != mno) {
            System.out.println("받은 메세지 조회 실패: 로그인 필요 또는 권한 없음");
            return new ArrayList<>();
        }
        System.out.println("보낸 메세지 조회: " + mno);
        // 1. 회원 찾기
        Optional <MemberEntity> memberOtp = memberRepository.findById(mno);
        List<MessageDto> list = new ArrayList<>();

        if(memberOtp.isPresent()) {
            System.out.println("회원 찾음: " + memberOtp.get().getMid());
            // 2. 받은 메세지 찾기 (삭제되지 않은 메세지만)
            List<MessageEntity> messageEntities = messageRepository.findByReceivermnoAndDeletedBySenderFalseAndDeletedByReceiverFalse(memberOtp.get()); // 삭제 X 메세지만 반환
            System.out.println("찾은 메세지 수: " + messageEntities.size());

            // 3. 엔티티 리스트 dto 변환
            messageEntities.forEach(entity -> {
                MessageDto dto = entity.toDto();
                // 송신자와 수신자 아이디 설정 => 화면에서 회원 번호가 아닌 실제 회원 아이디를 표시하기 위함
                dto.setSendmid(entity.getSendermno().getMid()); // 메시지 엔티티에서 송신자 엔티티를 가져와서 그 회원의 아이디를 가져옴
                dto.setReceivermid(entity.getReceivermno().getMid());

                list.add(dto);
                System.out.println("메세지 변환: " + dto.getMetitle());
            });
        } else {
            System.out.println("회원 찾을 수 없음");
        }
        return list;
    }

    // [3] 보낸 메세지 조회 추가 해야하는거: 삭제된 메세지 필터링
    @Transactional(readOnly = true)
    public List<MessageDto> FindSendMessage(int mno) {
        // 1. 로그인 상태 확인
        MemberDto loginDto = memberService.info();
        if(loginDto == null || loginDto.getMno() != mno) {
            System.out.println("받은 메세지 조회 실패: 로그인 필요 또는 권한 없음");
            return new ArrayList<>();
        }
        System.out.println("보낸 메세지 조회: " + mno);
        // 1. 회원 찾기
        Optional<MemberEntity> memberOtp = memberRepository.findById(mno);
        List<MessageDto> list = new ArrayList<>();

        if(memberOtp.isPresent()) {
            System.out.println("회원 찾음: " + memberOtp.get().getMid());
            // 2. 보낸 메세지 찾기
            List<MessageEntity> messageEntities = messageRepository.findBySendermnoAndDeletedBySenderFalseAndDeletedByReceiverFalse(memberOtp.get()); // 삭제 x 메세지만 반환
            System.out.println("찾은 메세지 수: " + messageEntities.size());

            // 3. 엔티티 리스트를 Dto 리스트로 반환 * 추가: 삭제되지 않은 메세지만 필터링
            messageEntities.forEach(entity -> {
                MessageDto dto = entity.toDto();
                // 송신자와 수신자의 아이디 설정
                dto.setSendmid(entity.getSendermno().getMid());
                dto.setReceivermid(entity.getReceivermno().getMid());

                list.add(dto);
                        System.out.println("메세지 변환: " + dto.getMetitle());
            });
        } else {
            System.out.println("회원 찾을 수 없음");
        }
        return list;
    }

//    // [4] 메세지 삭제
//    public boolean deleteMessage(int meno, int mno) {
//        try{
//            Optional<MessageEntity> messageOtp = messageRepository.findById(meno);
//
//            if(messageOtp.isPresent()){
//                MessageEntity message = messageOtp.get();
//                // 메세지 송신자나 수진자 요청한 사용자인 경우에만 삭제
//                if(message.getSendermno().getMno() == mno || message.getReceivermno().getMno() == mno) {
//                    messageRepository.delete(message);
//                    return true;
//                }
//            }
//            return false;
//        } catch (Exception e) {
//            System.out.println("메세지 삭제 실패: " + e);
//            return false;
//        }
//    }


    // [4] 보낸 메세지 삭제
    @Transactional
    public boolean deleteSendMessage(int meno, int mno) {
        // 1. 로그인 상태 확인
        MemberDto loginDto = memberService.info();
        if(loginDto == null || loginDto.getMno() != mno) {
            System.out.println("보낸 메세지 삭제 실패: 로그인 필요 또는 권한 없음");
            return false;
        }
        System.out.println("[보낸 메세지 삭제] meno: " + meno + ", mno: " + mno);
        try {
            Optional<MessageEntity> messageOtp = messageRepository.findById(meno);

            if (messageOtp.isPresent()) {
                MessageEntity message = messageOtp.get();
                System.out.println("[보낸 메세지 삭제] 메세지 찾음: " + message.getMetitle());

                // 송신자 확인
                if (message.getSendermno().getMno() == mno) {
                    // 메세지 엔티티만 삭제
                    //messageRepository.deleteById(meno);

                    // 추가
                    message.deleteBySender();
                    messageRepository.save(message); // 상태 업데이트
                    System.out.println("[보낸 메세지 삭제] 삭제 성공");
                    return true;
                } else {
                    System.out.println("[보낸 메세지 삭제] 권한 없음: 송신자가 아님");
                }
            } else {
                System.out.println("[보낸 메세지 삭제] 메세지를 찾을 수 없음");
            }
            return false;
        } catch (Exception e) {
            System.out.println("보낸 메세지 삭제 실패: " + e);
            return false;
        }
    }

    // [5] 받은 메세지 삭제
    @Transactional
    public boolean deleteReceiveMessage(int meno, int mno) {
        // 1. 로그인 상태 확인
        MemberDto loginDto = memberService.info();
        if(loginDto == null || loginDto.getMno() != mno) {
            System.out.println("받은 메세지 삭제 실패: 로그인 필요 또는 권한 없음");
            return false;
        }

        // 기존
        System.out.println("[받은 메세지 삭제] meno: " + meno + ", mno: " + mno);
        try {
            Optional<MessageEntity> messageOpt = messageRepository.findById(meno);

            if(messageOpt.isPresent()) {
                MessageEntity message = messageOpt.get();
                System.out.println("받은 메세지 삭제 메세지 찾음: " + message.getMetitle());

                // 수신자만 삭제 가능
                if(message.getReceivermno().getMno() == mno) {
                    message.deleteByReceiver();
                    messageRepository.save(message); // 상태 업데이트
                    System.out.println("받은 메세지 삭제 성공");
                    return true;
                } else {
                    System.out.println("받은 메세지 삭제 권한 없음: 수신자가 아님");
                }
            } else {
                System.out.println("받은 메세지 삭제 메세지를 찾을 수 없음");
            }
            return false;
        } catch (Exception e) {
            System.out.println("받은 메세지 삭제 실패" + e);
            return false;
        }
    }

    public int mno() {
        int mno=0;
        if(memberService.getSession()!=null) {
            mno = memberRepository.findByMid(memberService.getSession()).getMno();
        }
        return mno;
    }

    // ID로 회원번호 찾기
    public Integer findMnoById(String mid) {
        try {
            MemberEntity member = memberRepository.findByMid(mid);
            if (member != null) {
                return member.getMno();
            }
            return null;
        } catch (Exception e) {
            System.out.println("회원번호 조회 실패: " + e);
            return null;
        }
    }
}
