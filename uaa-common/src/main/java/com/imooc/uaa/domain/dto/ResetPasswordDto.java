package com.imooc.uaa.domain.dto;

import com.imooc.uaa.domain.MfaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emailOrMobile;

    private MfaType mfaType;
}
