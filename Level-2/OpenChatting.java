import java.util.*;

public class OpenChatting {
    public static String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        ArrayList<String> msgList = new ArrayList<>();
        String[] answer, msg;

        // 접속 user 내역 저장
        for (String r : record) {
            msg = r.split(" ");

            if (!msg[0].equals("Leave")) {
                userMap.put(msg[1], msg[2]); // key: 아이디, value: 닉네임
            }
        }

        // 메세지 출력
        for (String r : record) {
            msg = r.split(" ");

            switch (msg[0]) {
                case "Enter":
                    System.out.println(msg[1]);
                    System.out.println(userMap.get(msg[1]));
                    msgList.add(userMap.get(msg[1]) + "님이 들어왔습니다.");
                    break;

                case "Leave":
                    msgList.add(userMap.get(msg[1]) + "님이 나갔습니다.");
                    break;
            }
        }

        answer = new String[msgList.size()];
        for (int i = 0; i < msgList.size(); i++) {
            answer[i] = msgList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}