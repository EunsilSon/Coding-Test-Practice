public class WorldOf124 {
    public static String solution(int n) {
        String answer = "", result = "";
        int left;

        while (n != 0) {
            left = n % 3;
            switch (left) {
                case 1:
                    result = "1";
                    n /= 3;
                    break;
                case 2:
                    result = "2";
                    n /= 3;
                    break;
                case 0 :
                    result = "4";
                    n = (n / 3) - 1;
                    break;
            }
            answer = result + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}
