package com.imooc.uaa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TotpVerificationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String mfaId;
    @NotNull
    private String code;
}
