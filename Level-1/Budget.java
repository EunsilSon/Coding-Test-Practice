import java.util.Arrays;

public class Budget {
    public static int checkBudget(int[] d, int budget) {
        int count = 0, total = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (budget >= (total + d[i])) {
                total += d[i];
                ++count;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        System.out.println(checkBudget(d, 9)); // 3
    }
}
