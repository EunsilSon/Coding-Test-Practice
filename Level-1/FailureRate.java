import java.util.*;

class Stage implements Comparable<Stage> {
    int stage;
    double rate;

    public Stage (int stage, double rate) {
        this.stage = stage;
        this.rate = rate;
    }

    @Override
    public int compareTo(Stage node) {
        if (this.rate > node.rate)
            return -1;
        else if (this.rate == node.rate)
            return 0;
        else
            return 1;
    }
}

public class FailureRate {
    public static int[] solution(int N, int[] stages) {
        ArrayList<Stage> list = new ArrayList<>();
        int[] result = new int[N];
        double nowPlayer, clearPlayer, failRate;

        // 실패율 계산
        for (int i = 1; i <= N; i++) { // 전체 스테이지 개수 만큼 반복
            nowPlayer = 0;
            clearPlayer = 0;

            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) // i번 스테이지 도전 중인 사용자
                    nowPlayer++;
                if (i <= stages[j]) // i번 스테이지 클리어한 사용자
                    clearPlayer++;
            }
            failRate = (clearPlayer == 0) ? 0 : nowPlayer / clearPlayer;
            list.add(new Stage(i, failRate));
        }

        // 내림차순 정렬
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i).stage;

       return result;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(N, stages)));
    }
}
