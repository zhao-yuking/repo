package com.swpu.tjx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.swpu.tjx.domain.Materials;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.mapper.MaterialsMapper;
import com.swpu.tjx.mapper.WorkMapper;
import com.swpu.tjx.service.MaterialsService;
import com.swpu.tjx.utils.ResponseMessage;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.swpu.tjx.contant.UserConstant.WORK_OWN;

/**
* @author 朝俞
* @description 针对表【materials(参赛的材料信息表)】的数据库操作Service实现
* @createDate 2024-07-01 16:04:55
*/
@Service
public class MaterialsServiceImpl extends ServiceImpl<MaterialsMapper, Materials>
    implements MaterialsService {
    @Resource
    private WorkMapper workMapper;
    @Resource
    private MaterialsMapper materialsMapper;
    @Value("${file.upload.dir}")
    private String uploadFilePath;    //文件存放地址，从配置文件中取出的
    @Override
    public ResponseMessage UploadFile(MultipartFile[] multipartFiles, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Work work = (Work) request.getSession().getAttribute(WORK_OWN);
        int Mp4Len = 1;
        Materials materials = new Materials();
        List<String> tem1 =new ArrayList<>();
        List<String> tem2 =new ArrayList<>();
        List<String> tem3 =new ArrayList<>();
        List<String> tem4 =new ArrayList<>();
        boolean checked = false;
        int fileNum=0;
        try {
            for(int i = 0; i < multipartFiles.length; i++) {
                if(multipartFiles[i].isEmpty()){
                    return new ResponseMessage(500,"文件上传错误");
                }
                String fileName = multipartFiles[i].getOriginalFilename();
                String substring = fileName.substring(fileName.lastIndexOf("."));
                System.out.println(substring);
                if (".mp4".equals(substring)){
                    System.out.println("mp4"+fileName);
                    if(Mp4Len>=1&&Mp4Len<=3){
                        tem1.add(fileName);
                    }else if(Mp4Len>=4&&Mp4Len<=6){
                        tem2.add(fileName);
                    }else if(Mp4Len>=7&&Mp4Len<=9){
                        tem3.add(fileName);
                    }else{
                        tem4.add(fileName);
                    }
                    Mp4Len++;
                }else{
                    System.out.println("mp4else"+fileName);
                    if(!checked){
                        checked = true;
                        materials.setTeam1(tem1.toString());
                        materials.setTeam2(tem2.toString());
                        materials.setTeam3(tem3.toString());
                        materials.setTeam4(tem4.toString());
                    }
                    if(fileNum == 0){
                        materials.setTeachingThing(fileName);
                    }else if(fileNum == 1){
                        materials.setTeachingReport(fileName);
                    }else if(fileNum == 2){
                        materials.setPersonProgram(fileName);
                    }else if(fileNum == 3){
                        materials.setClassInformation(fileName);
                    } else if (fileNum ==4) {
                        materials.setTextbook(fileName);
                    }
                    fileNum++;
                }
                File fileTempObj = new File(uploadFilePath+"/"+work.getWorkName()+"/材料"+fileName);
                //文件存放目录不存在创建目录
                if(!fileTempObj.getParentFile().exists()){
                    fileTempObj.getParentFile().mkdir();
                }
                if(fileTempObj.exists()){
                    return new ResponseMessage(500,"上传错误文件已经存在");
                }
                try {
                    FileUtils.writeByteArrayToFile(fileTempObj,multipartFiles[i].getBytes());
                } catch (IOException e) {
                    System.out.println("文件上传错误"+e);
                    return new ResponseMessage(500,"文件上传错误",e);
                }
                jsonObject.put("file" + i, multipartFiles[i].getSize());
            }
        } catch (Exception e) {
            return new ResponseMessage(500,"上传材料信息失败",e);
        }
        materials.setWorkId(work.getWorkId());
        int insert = materialsMapper.insert(materials);
        if(insert != 1){
            return new ResponseMessage(500,"添加材料信息失败");
        }
        return new ResponseMessage(200,"上传材料信息成功",jsonObject);
    }
    //根据用户信息和参赛作品id进行查询作品材料进行打分
    @Override
    public ResponseMessage ExpertWork(HttpServletRequest request, Long workId) {
        Materials materials = materialsMapper.selectOne(new QueryWrapper<Materials>().eq("work_id", workId));
        return new ResponseMessage(200,"查询参赛材料成功",materials);
    }

    @Override
    public ResponseMessage downFile(String workName, String fileName, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        File file = new File(uploadFilePath+"/"+workName+"/"+fileName);
        if(!file.exists()){
            return new ResponseMessage(500,"下载失败");
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition","attachment;filename="+fileName);

        try {
            byte[] readBytes = FileUtils.readFileToByteArray(file);
            OutputStream os = response.getOutputStream();
            os.write(readBytes);
            result.put("sucess","下载成功");
        } catch (IOException e) {
            return new ResponseMessage(500,"下载失败");
        }
        return new ResponseMessage(200,"下载成功",result.toString());
    }

    @Override
    public ResponseMessage getScore(Long workId, Double score,String des) {
        workMapper.updateThescore(workId,score,des);
        return new ResponseMessage(200,"评分成功");
    }


}




