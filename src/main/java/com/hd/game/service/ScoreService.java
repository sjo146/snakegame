package com.hd.game.service;

import com.hd.game.domain.Score;
import com.hd.game.domain.Score_username;

import java.util.ArrayList;

public interface ScoreService {
    ArrayList<Score_username> selectTopTenScore();
    int insertScore(Score score);
    Score selectScoreByUid(int uid);
    int updateScore(Score score);
}
