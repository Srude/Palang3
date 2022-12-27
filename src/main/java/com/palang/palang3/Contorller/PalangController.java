package com.palang.palang3.Contorller;

import com.palang.palang3.domain.BoardVO;
import com.palang.palang3.domain.ResultVO;
import com.palang.palang3.persistence.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PalangController {
    private final UserMapper userMapper;

    @PostMapping("/user")
    public ResultVO addUser(@RequestBody BoardVO boardVO) {
        int result = userMapper.insertUser(boardVO);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/user/{user_email}")
    public BoardVO findOne(@PathVariable int user_email) {
        return userMapper.findOneUser(user_email);
    }

    @GetMapping("/users/list")
    public List<BoardVO> findAllUser() {
        return userMapper.findUser();
    }
}

