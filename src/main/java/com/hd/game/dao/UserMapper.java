package com.hd.game.dao;

import com.hd.game.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    /**
     * 搜索到具体项进行登录验证
     * @param name
     * @param pwd
     * @return
     */
    @Select(
            "select * from user where name = #{name} and password = #{pwd}"
    )
    User queryUserByIdAndPwd(@Param("name") String name, @Param("pwd") String pwd) ;

    @Insert("Insert into user (name,password) values(#{Name},#{Password})")
    @Options(useGeneratedKeys = true, keyProperty = "Uid", keyColumn = "uid")
    int insertNewUser(User user);
}
