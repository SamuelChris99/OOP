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
    static boolean win = false; // flag
    static boolean draw = false; // flag draw

    public static void validate(){
        for (int i = 0; i < 3; i++) {
            // cek baris
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                win = true;
            }
            // cek kolom
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '-') {
                win = true;
            }
            // cek diagonal
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') {
                win = true;
            }
            if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') {
                win = true;
            }
        }
    }

    // print board
    public static void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void player1(){
        printBoard();
        int x1 = -1, y1 = -1;
        do{
            System.out.print("Player 1 (O): ");
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
            printBoard();
            System.out.println("Player 1 win");
        }
    }

    public static void player2(){
        printBoard();
        int x2 = -1, y2 = -1;
        do{
            System.out.print("Player 2 (X): ");
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
            printBoard();
            System.out.println("Player 2 win");
        }
    }


    public static boolean boardFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        while(!win && !draw){
            player1();
            if(win) break;

            if(boardFull()){
                draw = true;
                break;
            }

            player2();
            if(win) break;

            if(boardFull()){
                draw = true;
                break;
            }
        }
        if(draw){
            printBoard();
            System.out.println("It's draw!");
        }
    }
}
