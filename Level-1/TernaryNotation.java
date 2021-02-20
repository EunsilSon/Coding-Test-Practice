public class TernaryNotation {
    public int solution(int n) {
        // 3진법 변환
        String ternary = "";

        while (n >= 1) {
            ternary += String.valueOf(n % 3);
            n = n / 3;
        }

        // 10진법 변환
        int result = 0;
        int length = ternary.length() - 1;

        for (int i = 0; i < ternary.length(); i++) {
            result += Character.getNumericValue(ternary.charAt(i)) * Math.pow(3, length--);
        }

        return result;
    }

    public static void main(String[] args) {
        TernaryNotation t = new TernaryNotation();
        System.out.println(t.solution(45));
        System.out.println(t.solution(125));
    }
}
