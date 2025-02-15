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
    public ResponseEntity<Boolean> sendMessage(@RequestBody MessageDto messageDto) {
        boolean result = messageService.send(messageDto);
        return ResponseEntity.ok(result);
    }

    // [2] 받은 메세지 조회
    @GetMapping("/message/receive/find.do") //
    public ResponseEntity<List<MessageDto>> findReceiveMessage(@RequestParam int receivermno){
        List<MessageDto> messages = messageService.FindReceiverMessage(receivermno);
        return ResponseEntity.ok(messages);
    }
//
    // [3] 보낸 메세지 조회
    @GetMapping("/message/send/find.do")
    public ResponseEntity<List<MessageDto>> FindSendMessage(@RequestParam int sendermno) {
        List<MessageDto> messages = messageService.FindSendMessage(sendermno);
        return ResponseEntity.ok(messages);
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

    // [4] 보낸 메세지 삭제
    @DeleteMapping("/message/send/delete.do")
    public ResponseEntity<Boolean> deleteSendMessage(@RequestParam int meno, @RequestParam int mno){
        boolean result = messageService.deleteSendMessage(meno,mno);
        if(result) {
            return ResponseEntity.ok(true);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }

    // [5] 받은 메세지 삭제
    @DeleteMapping("/message/receiver/delete.do")
    public ResponseEntity<Boolean> deleteReceiveMessage(@RequestParam int meno, @RequestParam int mno) {
        boolean result = messageService.deleteReceiveMessage(meno, mno);
        if(result) {
            return ResponseEntity.ok(true);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }


}
