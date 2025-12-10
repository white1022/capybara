package com.example.demo.entity;

import com.example.demo.listener.AutoTimeListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AutoTimeListener.class)
public class BaseEntity {

    @Column(columnDefinition = "int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间'")
    protected Integer createTime;

    @Column(columnDefinition = "int(10) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间'")
    protected Integer updateTime;

}
