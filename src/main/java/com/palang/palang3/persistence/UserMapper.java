package com.palang.palang3.persistence;

import com.palang.palang3.domain.BoardVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert({"<script>",
            "INSERT INTO user_tbl(user_email, user_name, user_pwd)",
            "VALUES(#{user_email}, #{user_name}, #{user_pwd})",
            "</script>"})
    int insertUser(BoardVO boardVO);

    @Select({"<script>",
            "SELECT * from user_tbl",
            "order by user_email desc",
            "</script>"})
    List<BoardVO> findUser();

    @Select({"<script>",
            "SELECT * from user_tbl",
            "where user_email = #{user_email}",
            "</script>"})
    BoardVO findOneUser(int user_email);

    int deleteBoard(int tbl_no);
}