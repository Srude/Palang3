package com.palang.palang3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter 자동 생성
@NoArgsConstructor//디폴트 생성자
@AllArgsConstructor//모든 파라미터를 가진 생성자
public class ResultVO {
    private int code;
    private String messsage;
}
