package devcom.controller;

import devcom.model.dto.BoardDto;
import devcom.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // 게시물 목록 조회 - 대외/취업
    @GetMapping("/board/advertise.do")
    public List<BoardDto> boardAdvertise(){
        return boardService.boardAdvertise();
    }

    // 게시물 목록 조회 - 튜토리얼
    @GetMapping("/board/tutorial.do")
    public List<BoardDto> boardTutorial(){
        return boardService.boardTutorial();
    }

    // 게시물 목록 조회 - 문제은행
    @GetMapping("/board/question.do")
    public List<BoardDto> boardQuestion(){
        return boardService.boardQuestion();
    }

    // 게시물 목록 조회 - 전체
    @GetMapping("/board/findall.do")
    public List<BoardDto> boardFindAll(){
        return boardService.boardFindAll();
    }

    // 게시물 쓰기
    @PostMapping("/board/write.do")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        return boardService.boardWrite(boardDto);
    }

    // 게시물 개별 조회
    @GetMapping("/board/find.do")
    public BoardDto boardFind(@RequestParam int index){
        return boardService.boardFind(index);
    }

    // 게시물 수정
    @PutMapping("/board/update.do")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return boardService.boardUpdate(boardDto);
    }

    // 게시물 삭제
    @DeleteMapping("/board/delete.do")
    public boolean boardDelete(@RequestParam int index){
        return boardService.boardDelete(index);
    }
}
