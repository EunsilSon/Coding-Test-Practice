import java.util.*;

public class CraneClawGame {
    public static int game(int[][] board, int[] moves) {
        int count = 0, move;
        Stack<Integer> toy = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            move = moves[i]-1; // 이동할 인덱스(board 기준) 1개 추출

            for (int x = 0; x < board.length; x++) {
                if (board[x][move] == 0) {
                    continue;
                } else {
                    if (toy.isEmpty()) {
                        toy.add(board[x][move]);
                    } else {
                        if (toy.peek() == board[x][move]) {
                            toy.pop();
                            count += 2;
                        } else {
                            toy.add(board[x][move]);
                        }
                    }
                    board[x][move] = 0;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = { {0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} };
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(game(board, moves)); // 4
    }
}
