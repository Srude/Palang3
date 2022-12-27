package com.palang.palang3.domain;

import lombok.Data;

@Data
public class ImageVO {
    private Integer tbl_no;
    private String mimetype;
    private String original_name;//파일 실제 이름
    private byte[] data;//파일 실제 내용
    private String created;
}
