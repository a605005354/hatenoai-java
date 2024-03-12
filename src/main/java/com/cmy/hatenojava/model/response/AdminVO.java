package com.cmy.hatenojava.model.response;

import lombok.Data;

import java.time.LocalDate;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.model.response
 * @className: AdminVO
 * @author: Terry Cai
 * @description: VO for admin
 * @date: 3/9/24 1:15 PM
 * @version: 1.0
 */
@Data
public class AdminVO {

    private String username;

    private String email;

    private LocalDate createAt;

    private String token;
}
