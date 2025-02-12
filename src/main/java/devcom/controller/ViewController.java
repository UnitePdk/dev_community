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

    //
}
