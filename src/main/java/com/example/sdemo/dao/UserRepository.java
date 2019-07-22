package com.example.sdemo.dao;

import com.example.sdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 09:30
 */

/**
 *   从封装的findone方法，得出原生的jpa的动态查询处理流程
 *   public T findOne(Specification<T> spec) {
 *
 *     try {
 *         return getQuery(spec, (Sort) null).getSingleResult();
 *     } catch (NoResultException e) {
 *         return null;
 *     }
 *   }
 *
 *   protected TypedQuery<T> getQuery(Specification<T> spec, Sort sort) {
 *
 *     CriteriaBuilder builder = em.getCriteriaBuilder();
 *     CriteriaQuery<T> query = builder.createQuery(getDomainClass());
 *
 *     Root<T> root = applySpecificationToCriteria(spec, query);
 *     query.select(root);
 *
 *     if (sort != null) {
 *         query.orderBy(toOrders(sort, root, builder));
 *     }
 *
 *     return applyRepositoryMethodMetadata(em.createQuery(query));
 *   }
 *
 *   private <S> Root<T> applySpecificationToCriteria(Specification<T> spec, CriteriaQuery<S> query) {
 *
 *     Assert.notNull(query);
 *     Root<T> root = query.from(getDomainClass());
 *
 *     if (spec == null) {
 *         return root;
 *     }
 *
 *     CriteriaBuilder builder = em.getCriteriaBuilder();
 *     Predicate predicate = spec.toPredicate(root, query, builder);
 *
 *     if (predicate != null) {
 *         query.where(predicate);
 *     }
 *
 *     return root;
 *   }
 *   综上所述
 *   CriteriaBuilder builder = em.getCriteriaBuilder();
 *   CriteriaQuery<T> query = builder.createQuery(getDomainClass());
 *   Root<T> root = query.from(getDomainClass());
 *   Predicate predicate = spec.toPredicate(root, query, builder);//springdatajpa封装好了后只需要重写这个方法
 *   query.where(predicate);
 *   query.select(root);
 *   query.orderBy(toOrders(sort, root, builder));
 *   query.getSingleResult();
 *
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    /**
     *  第一种方式根据方法名进行拼接
     *  spring-data-jpa会根据方法的名字来自动生成sql语句
     * @param name
     * @param password
     * @return
     */
    User findUserByNameAndPassword(String name,String password);

    @Query(value = " select * from #{#entityName} u where u.account = ?1 ",nativeQuery = true)
    User findUserByAccount(String account);
}
