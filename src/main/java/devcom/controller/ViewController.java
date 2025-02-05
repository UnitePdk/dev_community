package devcom.controller;

import lombok.Getter;
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
    @GetMapping("member/mypage")
    public String mypage(){ return "mypage.html";}

    // 수정 페이지 반환
    @GetMapping("member/update")
    public String myUpdate() { return "myUpdate.html";}

    //
}
