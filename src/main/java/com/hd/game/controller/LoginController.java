package com.hd.game.controller;

import com.alibaba.fastjson.JSONObject;
import com.hd.game.domain.User;
import com.hd.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService loginService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject login(@RequestBody JSONObject jsonParam) {
        System.out.println("Login------------");
        System.out.println(jsonParam.toJSONString()); // 将获取的json数据封装一层，然后在给返回
        User user=loginService.login(jsonParam.getString("Name"), jsonParam.getString("Password"));
        JSONObject result = new JSONObject();
        if(user==null){
            result.put("isOK", false);
        }
        else{
            result.put("isOK", true);
            result.put("uid",user.getUid());
        }
        System.out.println(result.toJSONString());
        return result;

    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject register(@RequestBody JSONObject jsonParam){
        User user=new User();
        user.setUid(jsonParam.getInteger("Uid"));
        user.setName(jsonParam.getString("Name"));
        user.setPassword(jsonParam.getString("Password"));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg",loginService.insertNewUser(user));
        return jsonObject;
    }
}
