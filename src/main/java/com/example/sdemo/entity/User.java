package com.example.sdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 09:33
 */

@Entity(name = "admin_user")
@Data
@Table(name = "admin_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private String account;
    private String password;

    @Column(name = "create_time")
    private Date createTime;
}
