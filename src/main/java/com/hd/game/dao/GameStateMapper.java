package com.hd.game.dao;

import com.hd.game.domain.GameState;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Mapper
public interface GameStateMapper {
    @Update(
            "update user_gamestate" +
                    " set " +
                    "applelist=#{Applelist}," +
                    "direction=#{Direction}," +
                    "nextdirection=#{Nextdirection}," +
                    "movedelay=#{Movedelay}," +
                    "score=#{Score}," +
                    "snaketail=#{Snaketail}," +
                    "troublelist=#{troublelist}," +
                    "slowlist=#{slowlist}," +
                    "quicklist=#{Quicklist}," +
                    "troubleclass=#{Troubleclass}" +
                    " where uid=#{Uid}"
    )
    int updateSnakestate(GameState gameState);

    @Select("select count(*) from user_gamestate " +
            "where uid=#{uid} ")
    int findSnakestateByuid(@Param("uid") int uid);
    @Insert("Insert into user_gamestate values(#{Uid},#{Applelist},#{Direction},#{Nextdirection},#{Movedelay},#{Score},#{Snaketail}" +
            ",#{troublelist},#{slowlist},#{Quicklist},#{Troubleclass}) ")
    int insertSnakestate(GameState gameState);
    @Select("select * from user_gamestate where uid=#{uid}")
    GameState getStateByUid(@Param("uid") int uid);

    @Delete("delete from user_gamestate where uid=#{uid}")
    int deleteStateByUid(@Param("uid") int uid);
}
