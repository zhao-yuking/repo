package com.swpu.tjx.controller;

import com.swpu.tjx.domain.User;
import com.swpu.tjx.service.WorkService;
import com.swpu.tjx.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.swpu.tjx.contant.UserConstant.JUDGE_ROLE;
import static com.swpu.tjx.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/front/expert")
public class ExpertController {

    @Resource
    private WorkService workService;

    @GetMapping("WorkList")
    public ResponseMessage WorkList(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user.getStatus()!=JUDGE_ROLE){
            return new ResponseMessage(500,"查询失败，非评委");
        }
        ResponseMessage responseMessage = workService.WorkList();
        return responseMessage;
    }
}
