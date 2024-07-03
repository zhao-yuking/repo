package com.swpu.tjx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.swpu.tjx.domain.User;
import com.swpu.tjx.mapper.UserMapper;
import com.swpu.tjx.service.UserService;
import com.swpu.tjx.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.swpu.tjx.contant.UserConstant.USER_LOGIN_STATE;


/**
* @author 朝俞
* @description 针对表【user(用户账号表)】的数据库操作Service实现
* @createDate 2024-07-01 16:05:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseMessage UserLogin(String userAccount, String userPassword, HttpServletRequest request) {
        if (StringUtils.isBlank(userAccount)){
            return new ResponseMessage(404,"用户账号为空");
        }
        if (StringUtils.isBlank(userPassword)){
            return new ResponseMessage(404,"用户密码为空");
        }

        if(userAccount.length() < 4){
            return new ResponseMessage(500,"账号长度过短");
        }
        if(userPassword.length() < 8){
            return new ResponseMessage(500,"密码长度过短");
        }
        //校验账户不能包含特殊字符
        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(userPassword);
        Matcher matcher1 = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()||matcher1.find()){
            return new ResponseMessage(500,"账号或密码不合法");
        }

        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("user_account", userAccount)
                .eq("user_password", userPassword));
        if(user == null){
            return new ResponseMessage(404,"账号密码错误");
        }
        //将登录对象存入session
        request.getSession().setAttribute(USER_LOGIN_STATE,user);
        //前端根据用户的status属性去选择用户身份进行是教师账号还是评委账号的跳转
        return new ResponseMessage(200,"登录成功",user);
    }

    @Override
    public ResponseMessage UpdatePwd(String userPassword, String newPassword, HttpServletRequest request) {
       User user = (User)request.getSession().getAttribute(USER_LOGIN_STATE);
       if(user==null){
           return new ResponseMessage(404,"账号错误,请登录");
       }
       if(user.getUserAccount().isEmpty()){
           return new ResponseMessage(404,"账号错误");
       }
        User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("user_account", user.getUserAccount()));
       if(user1 == null){
           return new ResponseMessage(404,"账号错误");
       }
       if(!user1.getUserPassword().equals(userPassword)){
//           System.out.println(user1.getUserPassword()+"--------"+userPassword);
           return new ResponseMessage(404,"旧密码输入错误");
       }

        if(newPassword.length() < 8){
            return new ResponseMessage(500,"密码长度过短");
        }
        //校验账户不能包含特殊字符
        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(newPassword);
        if(matcher.find()){
            return new ResponseMessage(500,"密码不合法");
        }
        user1.setUserPassword(newPassword);
        int update = userMapper.updateById(user1);
        if(update==0){
            return new ResponseMessage(500,"更改密码失败");
        }else{
            return new ResponseMessage(200,"更改密码成功");
        }
    }

    @Override
    public ResponseMessage UserLogout(HttpServletRequest request){
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return new ResponseMessage(200,"退出登录成功");
    }
}




