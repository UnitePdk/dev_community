package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.entity.MemberEntity;
import devcom.model.repository.FileRepository;
import devcom.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;
    @Autowired private FileService fileService;

    // 회원가입
    @Transactional
    public boolean signup(MemberDto memberDto){
        if (memberDto.getUploadfile().isEmpty()){
            memberDto.setMimg("default.jpg");
        } else {
            String fileName = fileService.fileUpload(memberDto.getUploadfile());
            if (fileName == null){return false;}
            else {
                memberDto.setMimg(fileName);
            }
        }
        // 엔티티 변환
        MemberEntity memberEntity = memberDto.toEntity();
        // 엔티티 저장
        MemberEntity saveEntity = memberRepository.save(memberEntity);
        return saveEntity.getMno() > 0;
    }
    // 로그인
    public boolean login(@RequestBody MemberDto memberDto){
        return false;
    }
    // 로그인 된 아이디 조회
    public String loginid(){
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
