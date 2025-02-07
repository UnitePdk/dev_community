package devcom.service;

import devcom.model.dto.BoardDto;
import devcom.model.entity.BoardEntity;
import devcom.model.repository.BoardRepository;
import devcom.model.repository.CategoryRepository;
import devcom.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<BoardDto> boardAsk() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 질문 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            if (entity.getCategoryEntity().getCno() == 1) {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
            }
        });

        return boardDtoList;
    }
}
