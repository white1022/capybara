package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.vo.UserVO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // DTO -> 实体
    UserEntity toEntity(UserDTO dto);

    // 实体 -> VO
    UserVO toVO(UserEntity entity);

    // 更新实体（忽略 null 字段）
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserDTO dto, @MappingTarget UserEntity entity);
}
