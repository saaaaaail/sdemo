package com.example.sdemo.dao;

import com.example.sdemo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 09:44
 */

public class UserRepositoryImpl  {
    /**
     * 第二种方式使用 JPQL，编写Repository接口的实现类
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Page<User> search(User user){
        String dataSql = "select t from User t where 1=1";
        String countSql = "select count(t) from User t where 1=1";

        if (user!=null&& !StringUtils.isEmpty(user.getName())){
            dataSql += " and t.name = ?1 ";
            countSql += " and t.name = ?1 ";
        }

        Query dataQuery = entityManager.createQuery(dataSql);
        Query countQuery = entityManager.createQuery(countSql);

        if (user!=null&& !StringUtils.isEmpty(user.getName())){
            dataQuery.setParameter(1,user.getName());
            countQuery.setParameter(1,user.getName());
        }

        long totalSize = (long)countQuery.getSingleResult();
        List<User> data = dataQuery.getResultList();
        PageImpl<User> page = new PageImpl<User>(data);
        return page;
    }


}
