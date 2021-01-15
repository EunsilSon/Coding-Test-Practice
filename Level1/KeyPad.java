/*
전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 '*' 키패드에 오른손 엄지손가락은 '#' 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
    4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.ArrayList;

class Node {
    public int x, y; // 좌표

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KeyPad {
    ArrayList<Node> keyPad = new ArrayList<>();

    public KeyPad() {
        // 숫자 키의 좌표 값
        keyPad.add(new Node(0,0)); // 1
        keyPad.add(new Node(0,1)); // 2
        keyPad.add(new Node(0,2)); // 3
        keyPad.add(new Node(1,0)); // 4
        keyPad.add(new Node(1,1)); // 5
        keyPad.add(new Node(1,2)); // 6
        keyPad.add(new Node(2,0)); // 7
        keyPad.add(new Node(2,1)); // 8
        keyPad.add(new Node(2,2)); // 9
        keyPad.add(new Node(3,0)); // 10 (*)
        keyPad.add(new Node(3,1)); // 11 (0)
        keyPad.add(new Node(3,2)); // 12 (#)
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int key;
        int leftH = 10, rightH = 12; // * 과 # 을 숫자로 표현
        int distanceL, distanceR; // 거리 계산 결과 값

        switch(hand) {
            case "left" :
                hand = "L";
                break;
            case "right" :
                hand = "R";
                break;
        }

        for(int i = 0; i < numbers.length; i++) {
            key = numbers[i] == 0 ? 11 : numbers[i]; // 0 은 11로 변경

            switch(key) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    leftH = key;
                    break;
                case 3:
                case 6:
                case 9:
                    answer += "R";
                    rightH = key;
                    break;
                case 2:
                case 5:
                case 8:
                case 11:
                    // leftH 와 rightH 거리 계산
                    distanceL = distance(keyPad, key, leftH);
                    distanceR = distance(keyPad, key, rightH);

                    if (distanceL < distanceR) { // left 가 더 가까울 때
                        answer += "L";
                        leftH = key;
                    } else if (distanceL > distanceR) { // right 가 더 가까울 때
                        answer += "R";
                        rightH = key;
                    } else { // 같을 때
                        answer += hand;

                        if (hand.equals("L"))
                            leftH = key;
                        else
                            rightH = key;
                    }
                    break;
            }
        }
        return answer;
    }

    public int distance(ArrayList<Node> keyPad, int key, int hand) {
        int result;
        int keyX, keyY, handX, handY, distanceX, distanceY, x1, x2, y1, y2;

        // 키의 좌표 값
        keyX = keyPad.get(key-1).x;
        keyY = keyPad.get(key-1).y;
        handX = keyPad.get(hand-1).x;
        handY = keyPad.get(hand-1).y;

        // 거리 계산
        x1 = keyX > handX ? keyX : handX;
        x2 = keyX < handX ? keyX : handX;
        y1 = keyY > handY ? keyY : handY;
        y2 = keyY < handY ? keyY : handY;

        distanceX = x1 - x2;
        distanceY = y1 - y2;

        result = distanceX + distanceY;

        return result;
    }

    public static void main(String[] args) {

        KeyPad keyPad = new KeyPad();

        int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }; // LRLLRRLLLRR
        String hand = "left";
        System.out.println(keyPad.solution(numbers, hand));
    }
}