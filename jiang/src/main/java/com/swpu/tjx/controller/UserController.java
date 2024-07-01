package com.swpu.tjx.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.swpu.tjx.service.UserService;
import com.swpu.tjx.service.impl.UserServiceImpl;
import com.swpu.tjx.utils.ResponseMessage;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping ("/front/user")
public class UserController {

    @Resource
    private UserService userService;

    //http://localhost:9001/front/user/UserLogin       用户登录接口
    @PostMapping("/UserLogin")
    public ResponseMessage UserLogin(@RequestParam("userAccount") String userAccount, @RequestParam("userPassword") String userPassword, HttpServletRequest request){
        ResponseMessage responseMessage = userService.UserLogin(userAccount, userPassword,request);
        return responseMessage;
    }

    //http://localhost:9001/front/user/UpdatePwd      //用户更改密码接口
    @PostMapping("/UpdatePwd")
    public ResponseMessage UpdatePwd(String userPassword,String newPassword,String reNewPassword,HttpServletRequest request){
        if(StringUtils.isBlank(newPassword)){
            return new ResponseMessage(404,"新密码为空");
        }
        if(StringUtils.isBlank(reNewPassword)){
            return new ResponseMessage(404,"二次密码为空");
        }
        if(!newPassword.equals(reNewPassword)){
            return new ResponseMessage(404,"输入二次密码错误，不一样");
        }
        ResponseMessage responseMessage = userService.UpdatePwd(userPassword, newPassword, request);

        return responseMessage;
    }
    //http://localhost:9001/front/user/UserLogout     //用户退出登录接口
    @GetMapping("UserLogout")
    public ResponseMessage UserLogout(HttpServletRequest request){
        if(request == null){
            return new ResponseMessage(500,"未登录");
        }
        ResponseMessage responseMessage = userService.UserLogout(request);
        return responseMessage;
    }
}
