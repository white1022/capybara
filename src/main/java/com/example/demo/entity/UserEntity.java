package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(
        name = "user",
        indexes = {
                @Index(name = "idx_name", columnList = "name")
        }
)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键'")
    private Integer id;

    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号'")
    private String account;

    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码'")
    private String password;

    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称'")
    private String name;

    @Column(columnDefinition = "int(10) unsigned NOT NULL DEFAULT '0' COMMENT '年龄'")
    private Integer age;

    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话'")
    private String phone;

}
