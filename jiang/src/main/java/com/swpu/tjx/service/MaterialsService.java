package com.swpu.tjx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.tjx.domain.Materials;
import com.swpu.tjx.utils.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author 朝俞
* @description 针对表【materials(参赛的材料信息表)】的数据库操作Service
* @createDate 2024-07-01 16:04:55
*/
public interface MaterialsService extends IService<Materials> {

    ResponseMessage UploadFile(MultipartFile[] multipartFiles, HttpServletRequest request);
}
