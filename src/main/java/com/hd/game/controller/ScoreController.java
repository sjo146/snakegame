package com.hd.game.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hd.game.dao.ScoreMapper;
import com.hd.game.domain.Score;
import com.hd.game.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @ResponseBody
    @RequestMapping(value = "/getTopTenRank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getTopTenRank(){
        JSONArray ja=new JSONArray();
        ja.add(scoreService.selectTopTenScore());
        return ja;
    }
    @ResponseBody
    @RequestMapping(value = "/updateUserScore", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSON updateUserScore(@RequestBody JSONObject jsonParam ){
        Score score=new Score();
        score.setScore(jsonParam.getLong("Score"));
        score.setUid(jsonParam.getInteger("Uid"));
        JSONObject jo=new JSONObject();
        /*
        如果数据库存在分数信息就更新，不存在就删除,并且只有分数比往期高才加入，否则不做任何动作
         */
        Score original=scoreService.selectScoreByUid(score.getUid());
        if(original!=null) {
            if(original.getScore()<score.getScore())
            jo.put("msg", scoreService.updateScore(score));
            else {
                jo.put("msg",-1);
                jo.put("msg1", "分数未刷新");
            }
        }
        else{
            jo.put("msg",scoreService.insertScore(score));
        }
        return  jo;
    }

}
