package com.imooc.uaa.repository.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.Assert;

@RequiredArgsConstructor
public class QueryDslRepositoryImpl<T> implements QueryDslRepository<T> {

    @Override
    public Page<T> findAll(JPAQuery<T> jpaQuery, Pageable pageable) {
        Assert.notNull(jpaQuery, "JPAQuery 不能为空!");
        Assert.notNull(pageable, "Pageable 不能为空!");

        return PageableExecutionUtils.getPage(
            // Clone query in order to provide entity manager instance.
            jpaQuery.limit(pageable.getPageSize()).offset(pageable.getOffset()).fetch(),
            pageable,
            jpaQuery::fetchCount);
    }
}
