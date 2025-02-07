package devcom.controller;

import devcom.model.dto.BoardDto;
import devcom.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 게시물 목록 조회 - 질문
    @GetMapping("/board/ask.do")
    public List<BoardDto>boardAsk(){
        return boardService.boardAsk();
    }

    // 게시물 목록 조회 - 질문

    // 게시물 목록 조회 - 질문

    // 게시물 목록 조회 - 질문

    // 게시물 목록 조회 - 전체
}
