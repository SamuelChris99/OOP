import java.util.Scanner;

/*
0 1 2
0 1 2
0 1 2
*/

public class Main {
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static Scanner obj = new Scanner(System.in); // object scanner

    static boolean win = false; //  sebuah flag

    public static void validate(){
        for (int i = 0; i < 3; i++) {
            // Cek baris
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                win = true;
            }
            // Cek kolom
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '-') {
                win = true;
            }
        }
        // Cek diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') {
            win = true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') {
            win = true;
        }
    }

    public static void printBoard(){ // print board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void player1(){
        printBoard();
        int x1 = -1, y1 = -1;
        do{
            System.out.print("Player 1 : ");
            x1 = obj.nextInt();
            y1 = obj.nextInt();
        }while (x1 < 0 || x1 > 3 || y1 < 0 || y1 > 3 ); // validasi input supaya tidak out of bound
        if(board[y1][x1] != '-'){ //  validasi spot terisi
            System.out.println("Spot taken. Input different spot!!");
            player1();
        }
        else{
            board[y1][x1] = 'O';
        }
        validate(); // validasi cek tic tac toe
        if(win) {
            System.out.println("You win");
        }
    }

    public static void player2(){
        printBoard();
        int x2 = -1, y2 = -1;
        do{
            System.out.print("Player 2 : ");
            x2 = obj.nextInt();
            y2 = obj.nextInt();
        }while (x2 < 0 || x2 > 3 || y2 < 0 || y2 > 3 );
        if(board[y2][x2] != '-' ){
            System.out.println("Spot taken. Input different spot!!");
            player2();
        }
        else{
            board[y2][x2] = 'X';
        }
        validate();
        if(win) {
            System.out.println("You win");
        }
    }

    public static void main(String[] args) {
        while(!win){
            player1();
            if(win) break;
            player2();
            if(win) break;
        }
    }
}
