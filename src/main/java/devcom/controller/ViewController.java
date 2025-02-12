package devcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 메인 페이지 반환
    @GetMapping("")
    public String index(){ return "index.html";}

    // 로그인 페이지 반환
    @GetMapping("/member/login")
    public String login(){ return "login.html";}

    // 회원 가입 페이지 반환
    @GetMapping("/member/signup")
    public String signup(){ return "signup.html";}

    // 마이페이지 반환
    @GetMapping("/member/mypage")
    public String mypage(){ return "mypage.html";}

    // 수정 페이지 반환
    @GetMapping("/member/update")
    public String myUpdate() { return "myUpdate.html";}

    // 문제은행 페이지 반환
    @GetMapping("/board/question")
    public String question() { return "/board/question/list.html";}

    // 질문/취업/튜토리얼 게시물 조회 페이지 반환
    
    // 문제은행 개별 게시물 조회 페이지 반환
    @GetMapping("/board/view")
    public String view() { return "/board/question/view.html";}
}
