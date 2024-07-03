package com.swpu.tjx.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.tjx.domain.Work;
import org.apache.ibatis.annotations.Update;

/**
* @author 朝俞
* @description 针对表【work(参赛作品信息表)】的数据库操作Mapper
* @createDate 2024-07-01 16:02:22
* @Entity generator.domain.Work
*/
public interface WorkMapper extends BaseMapper<Work> {

    @Update("UPDATE `work` SET work_scord = #{score},work_opinion= #{des} WHERE work_id = #{workId}")
    void updateThescore(Long workId, Double score,String des);
}




