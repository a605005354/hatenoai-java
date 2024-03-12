package com.cmy.hatenojava.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cmy.hatenojava.exceptions.ResponseException;
import com.cmy.hatenojava.model.db.Admin;
import com.cmy.hatenojava.model.request.AdminLoginReq;
import com.cmy.hatenojava.model.request.AdminReq;
import com.cmy.hatenojava.model.response.AdminVO;
import com.cmy.hatenojava.service.AdminService;
import com.cmy.hatenojava.utils.JwtUtils;
import com.cmy.hatenojava.utils.ResponseBody;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.controller
 * @className: AdminController
 * @author: Terry Cai
 * @description: Controller for Admin
 * @date: 2/25/24 5:02 PM
 * @version: 1.0
 */

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/signup")
    public Object signup(@RequestBody @Valid AdminReq adminReq) {
        try {
            adminService.signupAdmin(adminReq);
            String token = JwtUtils.generateToken(adminReq.getEmail());
            return ResponseBody.ok(token);
        } catch (ResponseException e) {
            return ResponseBody.fail(e.getMessage());
        }
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid AdminLoginReq adminLoginReq) {
        try {
            Admin admin = adminService.loginAdmin(adminLoginReq);
            AdminVO adminVO = new AdminVO();
            BeanUtils.copyProperties(admin, adminVO);
            String token = JwtUtils.generateToken(adminLoginReq.getEmail());
            adminVO.setToken(token);
            return ResponseBody.ok(adminVO);
        } catch (ResponseException e) {
            return ResponseBody.fail(e.getMessage());
        }
    }

    @PostMapping("/validateJwt")
    public Object validateJwt(@RequestBody String token) {
        try {
            JwtUtils.validateTokenAndRetrieveSubject(token);
            return ResponseBody.ok();
        } catch (JWTVerificationException e) {
            return ResponseBody.fail(e.getMessage());
        }
    }

}
