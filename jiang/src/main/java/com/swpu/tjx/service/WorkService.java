package com.swpu.tjx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.tjx.domain.User;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.utils.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author 朝俞
* @description 针对表【work(参赛作品信息表)】的数据库操作Service
* @createDate 2024-07-01 16:02:22
*/
public interface WorkService extends IService<Work> {

    ResponseMessage UploadFile(MultipartFile[] multipartFiles, HttpServletRequest request,Work work);

    ResponseMessage WorkList();
}
