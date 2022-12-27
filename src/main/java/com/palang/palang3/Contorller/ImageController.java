package com.palang.palang3.Contorller;

//import com.palang.palang3.domain.BoardVO;
import com.palang.palang3.domain.ImageVO;
import com.palang.palang3.persistence.ImageMapper;
import lombok.RequiredArgsConstructor;
//import org.apache.ibatis.annotations.Select;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageMapper imageMapper;

    @PostMapping("/upload")
    public Integer handleFileUpload(@RequestParam(value="file", required = false) MultipartFile file) throws IOException {

        ImageVO imageVO = new ImageVO();

        imageVO.setMimetype(file.getContentType());
        imageVO.setOriginal_name(file.getOriginalFilename());
        imageVO.setData(file.getBytes());
        imageMapper.insertBoard(imageVO);

        return imageVO.getTbl_no();
    }

    @GetMapping("/view/{tbl_no}")
    public ResponseEntity<byte[]> findOne(@PathVariable int tbl_no) {
        ImageVO imageVO = imageMapper.findOneImage(tbl_no);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", imageVO.getMimetype());
        headers.add("Content-Length", String.valueOf(imageVO.getData().length));

        return new ResponseEntity<byte[]>(imageVO.getData(), headers, HttpStatus.OK);
    }

}