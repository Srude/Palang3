package com.palang.palang3.persistence;

import com.palang.palang3.domain.ImageVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImageMapper {

    @Insert({"<script>",
            "INSERT INTO img_tbl(mimetype, original_name, data)",
            "VALUES(#{mimetype}, #{original_name}, #{data})",
            "</script>"})
    @Options(useGeneratedKeys = true, keyProperty = "tbl_no")
    int insertBoard(ImageVO imageVO);

    @Select({"<script>",
            "SELECT * from img_tbl",
            "where tbl_no = #{tbl_no}",
            "</script>"})
    ImageVO findOneImage(int tbl_no);
}