package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.vo.UserVO;

import java.util.List;

public interface UserService {
    UserVO create(UserDTO dto);
    UserVO update(Integer id, UserDTO dto);
    void delete(Integer id);
    UserVO get(Integer id);
    List<UserVO> list();
    Page<UserVO> page(int page, int size);
}
