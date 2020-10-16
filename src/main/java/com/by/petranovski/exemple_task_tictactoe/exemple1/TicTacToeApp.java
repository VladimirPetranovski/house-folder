package com.by.petranovski.exemple_task_tictactoe.exemple1;

import com.by.petranovski.exemple_task_tictactoe.exemple1.bean.TicTacToe;
import com.by.petranovski.exemple_task_tictactoe.exemple1.service.TicTacToeService;

class TicTacToeApp {
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToeService ticTacToeService = new TicTacToeService(ticTacToe);
        ticTacToeService.startGame();
    }
}
