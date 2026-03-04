package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // 构造方法
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserVO create(UserDTO dto) {
        UserEntity entity = userMapper.toEntity(dto);
        userRepository.save(entity);
        return userMapper.toVO(entity);
    }

    @Override
    public UserVO update(Integer id, UserDTO dto) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        userMapper.updateEntity(dto, entity);
        userRepository.save(entity);

        return userMapper.toVO(entity);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserVO get(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toVO)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    @Override
    public List<UserVO> list() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toVO)
                .toList();
    }

    @Override
    public Page<UserVO> page(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc("id")));
        Page<UserEntity> entityPage = userRepository.findAll(pageable);

        return entityPage.map(userMapper::toVO);
    }

    //throw new RuntimeException(messageSource.getMessage("user.notfound", null, LocaleContextHolder.getLocale())); //国际化

}
