package com.palang.palang3.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
//not_null 인 경우만 포함한다는 의미이므로 json을 만들때 property가 null이면 만들지 말라는 의미
@Data
public class BoardVO {
    private Integer tbl_no;
    private String tbl_name;
    private String tbl_txt;
    private Integer tbl_tag;
    private Integer tbl_cost;

    private String user_name;
    private String user_email;
    private String user_pwd;
}
