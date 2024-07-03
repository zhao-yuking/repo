package com.swpu.tjx.service.impl;



import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.tjx.domain.User;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.mapper.WorkMapper;
import com.swpu.tjx.service.WorkService;
import com.swpu.tjx.utils.ResponseMessage;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.swpu.tjx.contant.UserConstant.USER_LOGIN_STATE;
import static com.swpu.tjx.contant.UserConstant.WORK_OWN;

/**
* @author 朝俞
* @description 针对表【work(参赛作品信息表)】的数据库操作Service实现
* @createDate 2024-07-01 16:02:22
*/
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work>
    implements WorkService {
    @Resource
    private WorkMapper workMapper;
    @Value("${file.upload.dir}")
    private String uploadFilePath;    //文件存放地址，从配置文件中取出的
    @Override
    public ResponseMessage UploadFile(MultipartFile[] multipartFiles, HttpServletRequest request,Work work){
        JSONObject jsonObject = new JSONObject();
//        String fileNames[] = {"work_entry","work_publicity"};
        try {
            for(int i = 0; i < multipartFiles.length; i++) {
                if(multipartFiles[i].isEmpty()){
                    return new ResponseMessage(500,"文件上传错误");
                }
                String fileName = multipartFiles[i].getOriginalFilename();
                if(i==0){
                    work.setWorkEntry(fileName);
                }else{
                    work.setWorkPublicity(fileName);
                }
                File fileTempObj = new File(uploadFilePath+"/"+work.getWorkName()+"/"+fileName);
                //文件存放目录不存在创建目录
                if(!fileTempObj.getParentFile().exists()){
                    fileTempObj.getParentFile().mkdir();
                }
                if(fileTempObj.exists()){
                    return new ResponseMessage(500,"上传错误,文件已经存在");
                }
                try {
                    FileUtils.writeByteArrayToFile(fileTempObj,multipartFiles[i].getBytes());
                } catch (IOException e) {
                    System.out.println("文件上传错误"+e);
                    return new ResponseMessage(500,"文件上传错误",e);
                }
                jsonObject.put("file" + i, multipartFiles[i].getSize());
            }
            User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
            jsonObject.put("user", user.toString());
            work.setUserId(user.getUserId());
            LocalDate time = LocalDate.now();
            work.setCreatTime(time);
            jsonObject.put("work", work.toString());
            workMapper.insert(work);
            request.getSession().setAttribute(WORK_OWN,work);
        } catch (RuntimeException e) {
            return new ResponseMessage(500,"添加信息错误",e);
        }
        return new ResponseMessage(200,"文件上传成功",jsonObject);
    }

}




