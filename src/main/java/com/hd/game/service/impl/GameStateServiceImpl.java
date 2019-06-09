package com.hd.game.service.impl;

import com.hd.game.dao.GameStateMapper;
import com.hd.game.domain.GameState;
import com.hd.game.service.GameStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameStateServiceImpl implements GameStateService {
    @Autowired
    GameStateMapper gameStateMapper;

    @Override
    public int updateSnakestate(GameState gameState) {
        return gameStateMapper.updateSnakestate(gameState);
    }

    @Override
    public int findSnakestateByuid(int uid) {
        return gameStateMapper.findSnakestateByuid(uid);
    }

    @Override
    public int insertSnakestate(GameState gameState) {
        return gameStateMapper.insertSnakestate(gameState);
    }

    @Override
    public GameState getStateByUid(int uid) {
        return gameStateMapper.getStateByUid(uid);
    }

    @Override
    public int deleteStateByUid(int uid) {
        return gameStateMapper.deleteStateByUid(uid);
    }
}
