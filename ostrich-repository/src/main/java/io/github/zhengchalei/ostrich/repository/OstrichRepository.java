package io.github.zhengchalei.ostrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * atena库
 *
 * @author zhengchalei
 * @since 1.0.0
 */
@NoRepositoryBean
public interface OstrichRepository<T, ID extends Serializable> extends
        JpaRepository<T, ID>,
        JpaSpecificationExecutor<T>,
        QuerydslPredicateExecutor<T> {
}
