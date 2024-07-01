package com.swpu.tjx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.tjx.domain.User;
import com.swpu.tjx.utils.ResponseMessage;

import javax.servlet.http.HttpServletRequest;

/**
* @author 朝俞
* @description 针对表【user(用户账号表)】的数据库操作Service
* @createDate 2024-07-01 16:05:25
*/
public interface UserService extends IService<User> {
    ResponseMessage UserLogin(String userAccount, String userPassword, HttpServletRequest request);

    ResponseMessage UpdatePwd(String userPassword, String newPassword, HttpServletRequest request);

    ResponseMessage UserLogout(HttpServletRequest request);
}
