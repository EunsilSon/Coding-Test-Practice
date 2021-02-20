import java.util.*;

public class RecommendNewId {
    public static String checkNewId(String new_id) {
        String answer = "";
        char[] deleteChar = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', ',', '<', '>', '/'}; // 허용X 특수문자

        // 문자 한 개 씩 넣기
        LinkedList<Character> id = new LinkedList<>();
        for (int i = 0; i < new_id.length(); i++)
            id.add(new_id.charAt(i));

        // 1. 대문자 -> 소문자
        for (int i = 0; i < id.size(); i++)
            if (id.get(i) >= 65 && id.get(i) <= 90)
                id.set(i, (char)(id.get(i) + 32));

        // 2. 특수문자 제거
        for (int i = 0; i < id.size(); i++) {
            for (int j = 0; j < deleteChar.length; j++) {
                if (id.get(i) == deleteChar[j]) {
                    id.remove(i--);
                    break;
                }
            }
        }

        // 3. 마침표(.) 2개 이상 --> 1개만
        for (int i = 0; i < id.size(); i++)
            while ((i < id.size() - 1) && (id.get(i) == '.') && (id.get(i + 1) == '.'))
                id.remove(i + 1);

        // 4. 마침표(.) 처음 or 끝 --> 제거
        if (id.peekFirst() != null && id.peekFirst() == '.')
            id.removeFirst();

        if (id.peekLast() != null && id.peekLast() == '.')
            id.removeLast();

        // 5. 비어있으면 a' 삽입
        if (id.isEmpty())
            id.add('a');

        // 6. size == 15가 될 때 까지
        while (id.size() >= 16)
            id.removeLast();

        if (id.peekLast() != null && id.peekLast() == '.')
            id.removeLast();

        // 7. 길이가 2 이하이면 3이 될 때 까지 마지막 문자를 끝에 삽입
        while (id.size() < 3)
            id.add(id.peekLast());

        for (char value : id) answer += value;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(checkNewId("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(checkNewId("z-+.^."));
        System.out.println(checkNewId("=.="));
        System.out.println(checkNewId("123_.def"));
        System.out.println(checkNewId("abcdefghijklmn.p"));
        System.out.println(checkNewId("...abc..."));
    }
}