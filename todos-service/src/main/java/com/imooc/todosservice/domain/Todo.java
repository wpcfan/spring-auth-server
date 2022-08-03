package com.imooc.todosservice.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String desc;
    private String createdBy;
}
