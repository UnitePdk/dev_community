package devcom.controller;

import devcom.model.dto.BoardDto;
import devcom.model.dto.PageDto;
import devcom.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 게시물 목록 조회 - 문제은행
    @GetMapping("/board/findall.do")
    public PageDto boardFindAll(@RequestParam int cno, @RequestParam int page, @RequestParam int lno, @RequestParam String key, @RequestParam String keyword){
        return boardService.boardFindAll(cno, page, lno, key, keyword);
    }

    // 게시물 쓰기
    @PostMapping("/board/write.do")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        return boardService.boardWrite(boardDto);
    }

    // 게시물 개별 조회
    @GetMapping("/board/view.do")
    public BoardDto boardView(@RequestParam int index){
        return boardService.boardView(index);
    }

    // 게시물 수정
    @PutMapping("/board/update.do")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return boardService.boardUpdate(boardDto);
    }

    // 게시물 삭제
    @DeleteMapping("/board/delete.do")
    public int boardDelete(@RequestParam int index){
        return boardService.boardDelete(index);
    }

    // 현재 로그인된 멤버 조회
    @GetMapping("/getmno.do")
    public int getmno(){
        return boardService.getmno();
    }
}
