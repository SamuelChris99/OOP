import java.util.*;

public class Main {
    static boolean win = false;
    static boolean draw = false;

    public static void main(String[] args) {
        while (!win && !draw) {
            Player.playerMove('O');
            if (Board.validate()) {
                win = true;
                Board.printBoard();
                System.out.println("Player 1(O) win");
                break;
            }
            if (Board.boardFull()) {
                draw = true;
                break;
            }
            Player.playerMove('X');
            if (Board.validate()) {
                win = true;
                Board.printBoard();
                System.out.println("Player 2(X) win");
                break;
            }
            if (Board.boardFull()) {
                draw = true;
            }
        }
        if (draw) {
            Board.printBoard();
            System.out.println("It's draw!");
        }
    }
}
