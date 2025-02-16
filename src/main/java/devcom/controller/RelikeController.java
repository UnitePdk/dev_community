package devcom.controller;

import devcom.model.dto.RelikeDto;
import devcom.service.RelikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RelikeController {

    @Autowired private RelikeService relikeService;

    // 댓글 좋아요 추가
    @PostMapping("/reply/like/add.do")
    public boolean addLike(@RequestBody RelikeDto relikeDto) {
        return relikeService.addLike(relikeDto);
    }

    // 댓글 좋아요 삭제
    @DeleteMapping("/reply/like/delete.do")
    public boolean deleteLike(@RequestBody RelikeDto relikeDto) {
        return relikeService.deleteLike(relikeDto);
    }

}
