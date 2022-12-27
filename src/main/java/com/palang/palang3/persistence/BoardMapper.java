package com.palang.palang3.persistence;

import com.palang.palang3.domain.BoardVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert({"<script>",
            "INSERT INTO board_tbl(tbl_name, tbl_txt, tbl_tag, tbl_cost)",
            "VALUES(#{tbl_name}, #{tbl_txt}, #{tbl_tag}, #{tbl_cost})",
            "</script>"})
    int insertBoard(BoardVO boardVO);

    @Select({"<script>",
            "SELECT * from board_tbl",
            "order by tbl_no desc",
            "</script>"})
    List<BoardVO> findBoard();

    @Select({"<script>",
            "SELECT * from board_tbl",
            "where tbl_no = #{tbl_no}",
            "</script>"})
    BoardVO findOneBoard(int tbl_no);

    @Delete({"<script>",
            "DELETE FROM board_tbl",
            "WHERE tbl_no = #{tbl_no}",
            "</script>"})
    int deleteBoard(int tbl_no);
}
