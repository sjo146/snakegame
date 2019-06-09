package com.hd.game.service.impl;

import com.hd.game.dao.ScoreMapper;
import com.hd.game.domain.Score;
import com.hd.game.domain.Score_username;
import com.hd.game.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public ArrayList<Score_username> selectTopTenScore() {
        return scoreMapper.selectTopTenScore();
    }

    @Override
    public int insertScore(Score score) {
        return scoreMapper.insertScore(score);
    }

    @Override
    public Score selectScoreByUid(int uid) {
        return scoreMapper.selectScoreByUid(uid);
    }

    @Override
    public int updateScore(Score score) {
        return scoreMapper.updateScore(score);
    }
}
