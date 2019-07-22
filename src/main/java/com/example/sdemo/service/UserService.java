package com.example.sdemo.service;

import com.example.sdemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 14:01
 */

@Service
public interface UserService {
    /**
     *
     */
    public Page<User> search(final User user, Pageable pageable);
}
