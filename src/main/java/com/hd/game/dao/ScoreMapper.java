package com.hd.game.dao;

import com.hd.game.domain.Score;
import com.hd.game.domain.Score_username;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface ScoreMapper {
    /**
     * 搜索到分数排名前十的人的分数以及姓名
     * @return
     */
    @Select("select us.uid, us.score, u.name from user_score us,user u where us.uid=u.uid ORDER BY score DESC LIMIT 10")
    ArrayList<Score_username> selectTopTenScore();

    @Insert("insert into user_score(uid,score) values(#{Uid},#{Score})")
    int insertScore(Score score);

    @Select("select * from user_score where uid=#{uid}")
    Score selectScoreByUid(@Param("uid")int uid);

    @Update("update user_score set score=#{Score} where uid=#{Uid} ")
    int updateScore(Score score);


}
