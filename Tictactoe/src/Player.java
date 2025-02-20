import java.util.*;

public class Player {
    static Scanner obj = new Scanner(System.in);

    static void playerMove(char symbol) {
        Board.printBoard();
        int x, y;
        do {
            System.out.print("Player " + symbol + ": ");
            x = obj.nextInt();
            y = obj.nextInt();
        } while (x < 0 || x >= 3 || y < 0 || y >= 3 || Board.board[y][x] != '-');
        Board.board[y][x] = symbol;
    }
}