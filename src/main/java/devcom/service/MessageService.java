package devcom.service;

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

    // [1] 메세지 보내기
    public boolean send(MessageDto messageDto) {
        try{
            System.out.println("보내는 사람 ID: " + messageDto.getSendermno());
            System.out.println("받는 사람 ID: " + messageDto.getReceivermno());

            // 1. 보내는 사람과 받는 사람의 회원 엔티티 찾기
            Optional<MemberEntity> optionalSender = memberRepository.findById(messageDto.getSendermno());
            Optional<MemberEntity> optionalReceiver = memberRepository.findById(messageDto.getReceivermno());

            System.out.println("보내는 사람 존재 여부: " + optionalReceiver.isPresent());
            System.out.println("받는 사람 존재 여부: " + optionalSender.isPresent());

            if(optionalSender.isPresent() && optionalReceiver.isPresent()) {
                MemberEntity sender = optionalSender.get();
                MemberEntity receiver = optionalReceiver.get();
                System.out.println(receiver.getMno());

                // MessageEntity를 생성할 때 sender, receiver 설정
                MessageEntity messageEntity = MessageEntity.builder()
                        .metitle(messageDto.getMetitle())
                        .mecontent(messageDto.getMecontent())
                        .sendermno(sender)
                        .receivermno(receiver)
                        .build();

                messageRepository.save(messageEntity);
                return true;
            }

            System.out.println("메세지 전송 실패: 보낸사람 또는 받는 사람 없음");

            return false;
        } catch (Exception e) {
            System.out.println("메세지 전송 실패" + e);
            return false;
        }
    }

//    // [2] 받은 메세지 조회
//    @Transactional(readOnly = true)
//    public List<MessageDto> getReceiveMessages(int mno) {
//        // 1. 회원 찾기
//        Optional<MemberEntity> memberOtp = memberRepository.findById(mno);
//        List<MessageDto> list = new ArrayList<>();
//
//        if(memberOtp.isPresent()) {
//            // 2. 받은 메세지 찾기
//            List<MessageEntity> messageEntities = messageRepository.findByReceivermno(memberOtp.get());
//            // 3. 엔티티 리스트를 Dto 리스트로 변환
//            messageEntities.forEach(entity -> {MessageDto dto = entity.toDto();
//            // 송신자와 수신자의 아이디 설정
//            dto.setSendmid(entity.getSendermno().getMid());
//            dto.setReceivermid(entity.getReceivermno().getMid());
//            list.add(dto);
//            });
//        }
//        return list;
//    }

    // [2] 받은 메세지 조회
    @Transactional(readOnly = true)
    public List<MessageDto> FindReceiverMessage(int mno) {
        // 1. 회원 찾기
        Optional <MemberEntity> memberOtp = memberRepository.findById(mno);
        List<MessageDto> list = new ArrayList<>();

        if(memberOtp.isPresent()) {
            // 2. 받은 메세지 찾기
            List<MessageEntity> messageEntities = messageRepository.findByReceivermno(memberOtp.get());
            // 3. 엔티티 리스트 dto 변환
            messageEntities.forEach(entity -> {
                MessageDto dto = entity.toDto();
                // 송신자와 수신자 아이디 설정 => 화면에서 회원 번호가 아닌 실제 회원 아이디를 표시하기 위함
                dto.setSendmid(entity.getSendermno().getMid()); // 메시지 엔티티에서 송신자 엔티티를 가져와서 그 회원의 아이디를 가져옴
                dto.setReceivermid(entity.getReceivermno().getMid());

                list.add(dto);
            });
        }
        return list;
    }



//    // [3] 보낸 메세지 조회
//    @Transactional(readOnly = true)
//    public List<MessageDto> getSendMessages(int mno) {
//        // 1. 회원 찾기
//        Optional<MemberEntity> memberOtp = memberRepository.findById(mno);
//        List<MessageDto> list = new ArrayList<>();
//
//        if(memberOtp.isPresent()) {
//            // 2. 보낸 메세지 찾기
//            List<MessageEntity> messageEntities = messageRepository.findBySendermno(memberOtp.get());
//            // 3. 엔티티 리스트를 Dto 리스트로 변환
//            messageEntities.forEach(entity -> {
//                MessageDto dto = entity.toDto();
//                // 송신자와 수신자의 아이디 설정
//                dto.setSendmid(entity.getSendermno().getMid());
//                dto.setReceivermid(entity.getReceivermno().getMid());
//                list.add(dto);
//            });
//        }
//        return list;
//    }

    // [3] 보낸 메세지 조회
//    @Transactional(readOnly = true)
//    public List<MessageDto> FindSendMessages(int mno) {
//        // 1. 회원 찾기
//        Optional<MemberEntity> memberOtp = memberRepository.findById(mno);
//        List<MessageDto> list = new ArrayList<>();
//
//        if(memberOtp.isPresent()) {
//            // 2. 보낸 메세지 찾기
//        }
//    }

    // [4] 메세지 삭제
    public boolean deleteMessage(int meno, int mno) {
        try{
            Optional<MessageEntity> messageOtp = messageRepository.findById(meno);

            if(messageOtp.isPresent()){
                MessageEntity message = messageOtp.get();
                // 메세지 송신자나 수진자 요청한 사용자인 경우에만 삭제
                if(message.getSendermno().getMno() == mno || message.getReceivermno().getMno() == mno) {
                    messageRepository.delete(message);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("메세지 삭제 실패: " + e);
            return false;
        }
    }

    // [4] 보낸 메세지 삭제
    public boolean deleteSendMessage(int meno, int mno) {
        try{
            Optional<MessageEntity> messageOtp = messageRepository.findById(meno);

            if(messageOtp.isPresent()){
                MessageEntity message = messageOtp.get();
                // 송신자만 삭제 가능
                if(message.getSendermno().getMno() == mno) {
                    messageRepository.delete(message);
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            System.out.println("보낸 메세지 삭제 실패: " + e);
            return false;
        }
    }

    // [5] 받은 메세지 삭제
    public boolean deleteReceivedMessage(int meno, int mno) {
        try {
            Optional<MessageEntity> messageOpt = messageRepository.findById(meno);

            if(messageOpt.isPresent()) {
                MessageEntity message = messageOpt.get();
                // 수신자만 삭제 가능
                if(message.getReceivermno().getMno() == mno) {
                    messageRepository.delete(message);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("받은 메세지 삭제 실패" + e);
            return false;
        }
    }
}
