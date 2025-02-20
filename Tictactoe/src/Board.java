import java.util.*;

public class Board {
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    }; //tampilan board

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " "); //print board
            }
            System.out.println();
        }
    }

    static boolean boardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') { //untuk cek boardnya udah diisi semua atau belum
                    return false;
                }
            }
        }
        return true;
    }

    static boolean validate() {
        for (int i = 0; i < 3; i++) {
            //cek baris dan kolom
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') return true;
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '-') return true;
        }
        //cek diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') return true;
        return false;
    }
}