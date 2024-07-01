package com.swpu.tjx.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.tjx.domain.Work;
import com.swpu.tjx.mapper.WorkMapper;
import com.swpu.tjx.service.WorkService;
import org.springframework.stereotype.Service;

/**
* @author 朝俞
* @description 针对表【work(参赛作品信息表)】的数据库操作Service实现
* @createDate 2024-07-01 16:02:22
*/
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work>
    implements WorkService {

}




