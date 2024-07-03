package com.swpu.tjx.controller;

import com.swpu.tjx.domain.User;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.service.MaterialsService;
import com.swpu.tjx.service.WorkService;
import com.swpu.tjx.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.swpu.tjx.contant.UserConstant.JUDGE_ROLE;
import static com.swpu.tjx.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/front/expert")
public class ExpertController {

    @Resource
    private WorkService workService;

    @Resource
    private MaterialsService materialsService;
    //http://localhost:8091/front/expert/WorkList    评委进行参赛作品查询接口
    @GetMapping("WorkList")
    public ResponseMessage WorkList(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user == null){
            return new ResponseMessage(500,"查询失败，未登录");
        }
        if(user.getStatus()!=JUDGE_ROLE){
            return new ResponseMessage(500,"查询失败，非评委");
        }
        ResponseMessage responseMessage = workService.WorkList();
        return responseMessage;
    }

    //http://localhost:8091/front/expert/ExpertWork //评委加载材料信息
    public ResponseMessage ExpertWork(HttpServletRequest request,Long workId){
        User user =(User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user == null){
            return new ResponseMessage(500,"查询失败，未登录");
        }
        if(user.getStatus()!=JUDGE_ROLE){
            return new ResponseMessage(500,"查询失败，非评委");
        }
        ResponseMessage responseMessage = materialsService.ExpertWork(request, workId);
        return responseMessage;
    }

    //http://localhost:8091/front/expert/downFile //评委下载
    @PostMapping("downFile")
    public ResponseMessage downFile(HttpServletRequest request,String workName, String fileName, HttpServletResponse response){
        User user =(User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user == null){
            return new ResponseMessage(500,"查询失败，未登录");
        }
        if(user.getStatus()!=JUDGE_ROLE){
            return new ResponseMessage(500,"查询失败，非评委");
        }
        ResponseMessage responseMessage = materialsService.downFile(workName, fileName, response);
        return responseMessage;
    }

    //http://localhost:8091/front/expert/getScore //评委下载
    @PostMapping("getScore")
    public ResponseMessage getScore(HttpServletRequest request,Long workId,Double Score,String des){
        User user =(User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user == null){
            return new ResponseMessage(500,"查询失败，未登录");
        }
        if(user.getStatus()!=JUDGE_ROLE){
            return new ResponseMessage(500,"查询失败，非评委");
        }
        ResponseMessage responseMessage = materialsService.getScore(workId,Score,des);
        return responseMessage;
    }
}
