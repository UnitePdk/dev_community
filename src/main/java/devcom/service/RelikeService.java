package devcom.service;

import devcom.model.entity.ReplyEntity;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.RelikeRepository;
import devcom.model.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RelikeService {

    @Autowired private ReplyRepository replyRepository;
    @Autowired private RelikeRepository relikeRepository;





    }
