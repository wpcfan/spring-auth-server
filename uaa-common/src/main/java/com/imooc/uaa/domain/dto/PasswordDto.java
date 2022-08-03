package com.imooc.uaa.domain.dto;

import com.imooc.uaa.validation.ValidPassword;
import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String oldPassword;

    @ValidPassword
    private String newPassword;
}
