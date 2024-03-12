package com.cmy.hatenojava.model.request;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.model.request
 * @className: AdminReq
 * @author: Terry Cai
 * @description: Request for admin
 * @date: 2/27/24 10:27 AM
 * @version: 1.0
 */
@Data
public class AdminReq {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}
