package devcom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    String path = "\\dev_community\\build\\resources\\main\\static\\img";

    // 업로드 함수
    public String fileUpload(MultipartFile multipartFile){
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "-" + multipartFile.getOriginalFilename().replaceAll("-", "_");
        String uploadFile = path + fileName;
        // File 객체
        File file = new File(uploadFile);
        // 업로드
        try{
            multipartFile.transferTo(file);
        }catch (IOException e){
            System.out.println("파일 업로드 실패" + e);
            return null;
        }
        return fileName;
    }
}
