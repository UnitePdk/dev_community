package devcom.controller;

import devcom.model.dto.MessageDto;
import devcom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired private MessageService messageService;

    // [1] 메세지 보내기
    @PostMapping("/message/send.do") //http://localhost:8080/message/send.do
    public boolean sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.send(messageDto);
    }

    // [2] 받은 메세지 조회
    @GetMapping("/message/receive/find.do") //
    public List<MessageDto> FindReceiveMessage(@RequestParam int mno){ // 회원 조회
        return messageService.getReceiveMessages(mno);
    }

    // [3] 보낸 메세지 조회
    @GetMapping("/message/send/find.do")
    public List<MessageDto> FindSendMessage(@RequestParam int mno) {
        return messageService.getSendMessages(mno);
    }


//    // 메세지 삭제
//    @DeleteMapping("/message/delete.do")
//    public ResponseEntity<String> deleteMessage(@PathVariable int meno, @PathVariable int mno) {
//        boolean result = messageService.deleteMessage(meno, mno);
//        if(result) {
//            return ResponseEntity.ok("메세지 삭제 성공");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("메세지 삭제 실패");
//        }
//    }

    // [4] 받은 메세지 삭제
    @DeleteMapping("/message/send/delete.do")
    public boolean deleteSendMessage(@RequestParam int meno, @RequestParam int mno) {
        return messageService.deleteSendMessage(meno, mno);
    }

    // [5] 보낸 메세지 삭제
    @DeleteMapping("/message/receiver/delete.do")
    public boolean deleteReceiveMessage(@RequestParam int meno, @RequestParam int mno) {
        return messageService.deleteReceivedMessage(meno, mno);
    }


}
