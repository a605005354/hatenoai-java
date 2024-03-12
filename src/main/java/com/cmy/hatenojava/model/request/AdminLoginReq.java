package com.cmy.hatenojava.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.model.request
 * @className: AdminLoginReq
 * @author: Terry Cai
 * @description: Admin Request for login
 * @date: 3/7/24 1:17 PM
 * @version: 1.0
 */
@Data
public class AdminLoginReq {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

}
