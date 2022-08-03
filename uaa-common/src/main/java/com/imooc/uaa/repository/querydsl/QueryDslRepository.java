package com.imooc.uaa.repository.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryDslRepository<T> {
    Page<T> findAll(JPAQuery<T> jpaQuery, Pageable pageable);
}
