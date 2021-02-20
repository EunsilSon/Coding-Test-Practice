public class CollatzConjecture {
    public static int collatz(long num) {
        int count = 0;

        while (!(num == 1)) {
            if (count == 500) // 반복 횟수
                return -1;

            if ((num % 2) == 0) { // 짝수
                num /= 2;
            } else { // 홀수
                num = (num * 3) + 1;
            }
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(collatz(6)); // 4
        System.out.println(collatz(16)); // 8
        System.out.println(collatz(626331)); // -1
    }
}
