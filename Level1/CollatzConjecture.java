public class CollatzConjecture {
    public static int Collatz(long num) {
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
        System.out.println(Collatz(626331)); // -1
    }
}