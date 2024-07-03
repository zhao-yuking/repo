package com.swpu.tjx.controller;

import com.alibaba.fastjson.JSONObject;
import com.swpu.tjx.domain.User;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.service.MaterialsService;
import com.swpu.tjx.service.WorkService;
import com.swpu.tjx.service.impl.WorkServiceImpl;
import com.swpu.tjx.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;

import static com.swpu.tjx.contant.UserConstant.*;

@RestController
@RequestMapping("/front/workfile")
public class WorkController {

    @Resource
    private WorkService workService;

    @Resource
    private MaterialsService materialsService;

    //http://localhost:8091/front/workfile/UploadFile       对文件进行上传
    @PostMapping("/UploadFile")
    public ResponseMessage UploadFile(@ApiParam(value = "multipartFile") @RequestParam MultipartFile[] multipartFiles, @Valid HttpServletRequest request,@Valid Work work){
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user == null){
            return new ResponseMessage(500,"上传错误，请先登录");
        }
        if(user.getStatus()!=TEACHER_ROLE){
            return new ResponseMessage(500,"错误，非老师身份");
        }
        if(multipartFiles == null){
            return new ResponseMessage(500,"controller:上传错误，文件为空");
        }
        ResponseMessage  responseMessage = workService.UploadFile(multipartFiles, request,work);

        return responseMessage;
    }

    //http://localhost:8091/front/workfile/UploadMaterials       上传材料
    @PostMapping("/UploadMaterials")
    public ResponseMessage UploadMaterials(@ApiParam(value = "multipartFile") @RequestParam MultipartFile[] multipartFiles, @Valid HttpServletRequest request){
        Work work = (Work) request.getSession().getAttribute(WORK_OWN);
        if(work == null){
            return new ResponseMessage(500,"上传参赛作品错误，请先填写作品信息");
        }
        if(multipartFiles == null){
            return new ResponseMessage(500,"controller:上传错误，文件为空");
        }
        ResponseMessage  responseMessage = materialsService.UploadFile(multipartFiles, request);

        return responseMessage;
    }


}
