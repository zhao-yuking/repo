package com.swpu.tjx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.swpu.tjx.domain.Materials;
import com.swpu.tjx.mapper.MaterialsMapper;
import com.swpu.tjx.service.MaterialsService;
import org.springframework.stereotype.Service;

/**
* @author 朝俞
* @description 针对表【materials(参赛的材料信息表)】的数据库操作Service实现
* @createDate 2024-07-01 16:04:55
*/
@Service
public class MaterialsServiceImpl extends ServiceImpl<MaterialsMapper, Materials>
    implements MaterialsService {

}




