package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result<UserVO> create(@Valid @RequestBody UserDTO dto) {
        return Result.success(userService.create(dto));
    }

    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable Integer id) {
        return Result.success(userService.get(id));
    }

    @PutMapping("/{id}")
    public Result<UserVO> update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        return Result.success(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Result.success(userService.delete(id));
    }

    @GetMapping
    public List<UserVO> list() {
        return Result.success(userService.list());
    }

    @GetMapping("/page")
    public Result<?> page(@RequestParam int page,
                          @RequestParam int size) {
        return Result.success(userService.page(page, size));
    }


}
