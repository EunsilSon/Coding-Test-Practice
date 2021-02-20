import java.util.Arrays;

public class TriangleSnail {
    public static int[] snail(int n) {
        int maxNum = n * (n + 1) / 2; // 달팽이 안에 최대 칸 개수
        int[] answer = new int[maxNum];
        int[][] snail = new int[n][n];

        int x = -1, y = 0, fill = n;

        int count = 1; // 달팽이 안의 데이터
        while (count <= maxNum) {
            // 아래로
            for (int i = 0; i < fill; i++)
                snail[++x][y] = count++;
            fill--;

            // 옆으로
            for (int i = 0; i < fill; i++)
                snail[x][++y] = count++;
            fill--;

            // 위로
            for (int i = 0; i < fill; i++)
                snail[--x][--y] = count++;
            fill--;

            // 1차원 배열에 옮기기
            int idx = 0;
            for (int i = 0; i < snail.length; i++)
                for (int j = 0; j < snail.length; j++)
                    if (snail[i][j] != 0)
                        answer[idx++] = snail[i][j];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] snail = snail(4);
        System.out.println(Arrays.toString(snail)); // [1,2,9,3,10,8,4,5,6,7]
    }
}
