package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    // 회원가입
    public boolean signup(MemberDto memberDto){
        return false;
    }
    // 로그인
    public boolean login(@RequestBody MemberDto memberDto){
        return false;
    }
    // 로그인 된 아이디 조회
    public String loggedid(){
        return null;
    }
    // 로그아웃
    public boolean logout(){
        return false;
    }
    // 로그인 된 회원 정보 조회
    public MemberDto info(){
        return null;
    }
    // 로그인 된 회원 탈퇴
    public boolean delete(){
        return false;
    }
    // 로그인 된 회원 정보 수정
    public boolean update(@RequestBody MemberDto memberDto){
        return false;
    }

}
