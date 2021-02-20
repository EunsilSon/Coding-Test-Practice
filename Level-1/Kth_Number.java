/*
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k 번째에 있는 수를 구하려 합니다.

예를 들어 array 가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array 의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands 가 매개변수로 주어질 때,
commands 의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를
배열에 담아 return 하도록 solution 함수를 작성해주세요.

입출력 예
-> array[1, 5, 2, 6, 3, 7, 4]
-> commands[[2, 5, 3], [4, 4, 1], [1, 7, 3]]
-> return[5, 6, 3]
 */

public class Kth_Number {
    public static int[] solution(int[] array, int[][] commands) {
        int command = commands.length;
        int[] answer = new int[command]; // k번째 수 배열

        for(int i = 0; i < commands.length; i++) {
            int[] temp = new int[100]; // 자른 배열
            int n = 0;

            // i 번째 수 부터 j 번째 수 까지 자르기
            for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
                temp[n] = array[j];
                ++n;
            }

            // 정렬
            int t;
            for(int a = 0; a < temp.length; a++) {
                for(int b = 0; b < temp.length; b++) {
                    if (temp[a] == 0) {
                        continue;
                    }
                    if (temp[a] < temp[b]) {
                        t = temp[b];
                        temp[b] = temp[a];
                        temp[a] = t;
                    }
                }
            }

            // k번째 수
            int k = commands[i][2];
            answer[i] = temp[k-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        int[] answer = solution(array, commands);

        for(int k : answer)
            System.out.print(k + " ");
    }
}
