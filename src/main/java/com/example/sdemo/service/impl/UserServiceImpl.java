package com.example.sdemo.service.impl;

import com.example.sdemo.dao.UserRepository;
import com.example.sdemo.entity.User;
import com.example.sdemo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 14:02
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> search(User user, Pageable pageable) {
        return userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                Predicate uNameLike = null;
                if (user!=null && !StringUtils.isEmpty(user.getName())){
                    uNameLike = criteriaBuilder.like(root.<String>get("name"),"%"+user.getName()+"%");
                    predicates.add(uNameLike);
                }
                Predicate uPassLike = null;
                if (user!=null && !StringUtils.isEmpty(user.getPassword())){
                    uPassLike = criteriaBuilder.equal(root.get("password"),user.getPassword());
                    predicates.add(uPassLike);
                }
                /** 也可以不写
                if (uNameLike!=null){
                    criteriaQuery.where(uNameLike);
                }
                if (uPassLike!=null){
                    criteriaQuery.where(uPassLike);
                }
                    将predicate统一返回
                 */
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
    }
}
