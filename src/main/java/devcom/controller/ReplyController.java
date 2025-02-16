package devcom.controller;

import devcom.model.dto.ReplyDto;
import devcom.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired private ReplyService replyService;

    // 댓글 목록 가져오기
    @GetMapping("/reply/findall.do")
    public List<ReplyDto> replyDtoList() {
        return replyService.replyFindAll();
    }

    // 댓글 작성하기
    @PostMapping("/reply/write.do")
    public boolean replyWrite(@RequestBody ReplyDto replyDto) {
       return replyService.replyWrite(replyDto);
    }

    // 댓글 수정
    @PutMapping("/reply/update.do")
    public boolean replyUpdate(@RequestBody ReplyDto replyDto) {
        return replyService.replyUpdate(replyDto);
    }

    // 댓글 삭제
    @DeleteMapping("/reply/delete.do")
    public boolean replyDelete(@RequestParam int rno) {
        return replyService.replyDelete(rno);
    }

}
