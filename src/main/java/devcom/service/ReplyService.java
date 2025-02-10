package devcom.service;

import devcom.model.dto.ReplyDto;
import devcom.model.entity.BoardEntity;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired ReplyRepository replyRepository;

    // 댓글 저장
    public ReplyEntity saveReply(ReplyDto replyDto, MemberEntity memberEntity, BoardEntity boardEntity) {
        ReplyEntity reply = ReplyEntity.builder()
                .rcontent((replyDto.getRcontent()))
                .relike(0)
                .memberEntity(memberEntity)
                .boardEntity(boardEntity)
                .build();

        return replyRepository.save(reply);
    }

}
