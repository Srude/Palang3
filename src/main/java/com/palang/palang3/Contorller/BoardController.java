package com.palang.palang3.Contorller;

import com.palang.palang3.domain.BoardVO;
import com.palang.palang3.domain.ResultVO;
import com.palang.palang3.persistence.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardMapper boardMapper;

    @PostMapping("/board")
    public ResultVO addBoard(@RequestBody BoardVO boardVO) {
        int result = boardMapper.insertBoard(boardVO);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/board/{tbl_no}")
    public BoardVO findOne(@PathVariable int tbl_no) {
        return boardMapper.findOneBoard(tbl_no);
    }

    @GetMapping("/boards")
    public List<BoardVO> findAllBoard() {
        return boardMapper.findBoard();
    }

    @DeleteMapping("/board") //Request의 body가 존재하지 않음
    public ResultVO removeBoard(@RequestParam int tbl_no) {
        int result = boardMapper.deleteBoard(tbl_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }
}
