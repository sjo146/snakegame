package com.hd.game.service;

import com.hd.game.domain.GameState;

public interface GameStateService {
    int updateSnakestate(GameState gameState);

    int findSnakestateByuid(int uid);

    int insertSnakestate(GameState gameState);
    GameState getStateByUid(int uid);
    int deleteStateByUid(int uid);
}
