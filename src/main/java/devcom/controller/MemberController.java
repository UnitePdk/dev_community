package devcom.controller;

import devcom.model.dto.MemberDto;
import devcom.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    // 회원가입
    @PostMapping("/member/signup.do")
    public boolean signup(MemberDto memberDto){ // multipart/form-data
        return memberService.signup(memberDto); // *첨부파일 포함
    }
    // 로그인
    @PostMapping("/member/login.do")
    public boolean login(@RequestBody MemberDto memberDto){
        return memberService.login(memberDto);
    }
    // 로그인 된 아이디 조회
    @GetMapping("/member/login/id")
    public String loginid(){
        return memberService.loginid();
    }
    // 로그아웃
    @GetMapping("/member/logout.do")
    public boolean logout(){
        return memberService.logout();
    }
    // 로그인 된 회원 정보 조회
    @GetMapping("/member/info.do")
    public MemberDto info(){
        return memberService.info();
    }
    // 로그인 된 회원 탈퇴
    @DeleteMapping("/member/delete.do")
    public boolean delete(){
        return memberService.delete();
    }
    // 로그인 된 회원 정보 수정
    @PutMapping("/member/update.do")
    public boolean update(@RequestBody MemberDto memberDto){
        return memberService.update(memberDto);
    }

}
