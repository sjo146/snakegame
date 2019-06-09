package com.hd.game.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hd.game.domain.GameState;
import com.hd.game.service.GameStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class GameStateController {
    @Autowired
    GameStateService gameStateService;

    @ResponseBody
    @RequestMapping(value = "/uploadSnakestate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject uploadSnakestate(@RequestBody JSONObject jsonParam) {
        System.out.println("uploadSnakestate------------");
        System.out.println(jsonParam.toJSONString());
        GameState gameState = new GameState();
        gameState.setUid(jsonParam.getInteger("Uid"));
        gameState.setApplelist(jsonParam.getString("Applelist"));
        gameState.setDirection(jsonParam.getInteger("Direction"));
        gameState.setNextdirection(jsonParam.getInteger("Nextdirection"));
        gameState.setMovedelay(jsonParam.getInteger("Movedelay"));
        gameState.setSnaketail(jsonParam.getString("Snaketail"));
        gameState.setScore(jsonParam.getLong("Score"));
        gameState.setTroubleclass(jsonParam.getInteger("Troubleclass"));
        gameState.setTroublelist(jsonParam.getString("Troublelist"));
        gameState.setSlowlist(jsonParam.getString("Slowlist"));
        gameState.setQuicklist(jsonParam.getString("Quicklist"));

        if (gameStateService.findSnakestateByuid(gameState.getUid()) == 0)
            gameStateService.insertSnakestate(gameState);
        else {
            gameStateService.updateSnakestate(gameState);
        }
        JSONObject jo = new JSONObject();
        jo.put("ok", "ok");
        return jo;
    }

    @ResponseBody
    @RequestMapping(value = "/getSnakestate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSON getSnakestate(@RequestBody JSONObject jsonParam) {
        System.out.println("getSnakestate------------");
        System.out.println(jsonParam.toJSONString());
        int uid = jsonParam.getInteger("uid");
        JSONArray jar = new JSONArray();
        if(gameStateService.findSnakestateByuid(uid)>0){
        jar.add(gameStateService.getStateByUid(uid));
      //  System.out.println(jar.getJSONObject(0).toJSONString());
        }
        return jar;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteState", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSON deleteState(@RequestBody JSONObject jsonParam) {
        System.out.println("deleteState------------");
        System.out.println(jsonParam.toJSONString());
        int uid = jsonParam.getInteger("uid");
        if(gameStateService.findSnakestateByuid(uid)==1)
        gameStateService.deleteStateByUid(uid);
        JSONObject jo = new JSONObject();
        jo.put("state", "ok");
        return jo;
    }
}
