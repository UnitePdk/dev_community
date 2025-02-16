package devcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 메인 페이지 반환
    @GetMapping("")
    public String index(){ return "/index.html";}

    // 로그인 페이지 반환
    @GetMapping("/member/login")
    public String login(){ return "/member/login.html";}

    // 회원 가입 페이지 반환
    @GetMapping("/member/signup")
    public String signup(){ return "/member/signup.html";}

    // 마이페이지 반환
    @GetMapping("/member/info")
    public String info(){ return "/member/info.html";}

    // 수정 페이지 반환
    @GetMapping("/member/update")
    public String Update() { return "/member/update.html";}

    // 문제은행 페이지 반환
    @GetMapping("/board/ask")
    public String ask() { return "/board/ask/list.html";}

    // 문제은행 페이지 반환
    @GetMapping("/board/advertise")
    public String advertise() { return "/board/advertise/list.html";}

    // 문제은행 페이지 반환
    @GetMapping("/board/tutorial")
    public String tutorial() { return "/board/tutorial/list.html";}


    // 문제은행 페이지 반환
    @GetMapping("/board/question")
    public String question() { return "/board/question/list.html";}

    // 질문/취업/튜토리얼 게시물 조회 페이지 반환
    
    // 문제은행 개별 게시물 조회 페이지 반환
    @GetMapping("/board/view")
    public String view() { return "/board/question/view.html";}

    // 메시지 목록 페이지 반환
    @GetMapping("/messages")
    public String messageList() { return "/message/message.html";}

    // 메시지 작성 페이지 반환
    @GetMapping("/messages/write")
    public String messageWrite() { return "/message/write.html";}
}
