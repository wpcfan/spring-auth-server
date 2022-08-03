package com.imooc.webclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String desc;
    private String createdBy;
}
