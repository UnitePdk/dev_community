package devcom.controller;

import devcom.service.RelikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RelikeController {

    @Autowired private RelikeService relikeService;

    // 댓글 좋아요 추가

}
