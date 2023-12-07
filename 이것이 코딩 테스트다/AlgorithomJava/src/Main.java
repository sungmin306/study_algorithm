import java.util.*;
import java.io.*;


public class Main {
    public static final String s = "713"; // 나중에 랜덤으로 만들거임

    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        while(true) { // 게임 호출 메서드
            int n = Integer.parseInt(s);
            int length = (int)(Math.log10(n) + 1);
            if(length != 3) // 자리 수 확인 및 같은 숫자가 존재하는지 확인해야함 - 메서드
                throw new IllegalArgumentException("시스템을 종료합니다");
            else{
                System.out.print("숫자를 입력해주세요 : ");
                String inputStringNumber = sc.nextLine();
                int inputNumber = Integer.parseInt(inputStringNumber);
                if(n == inputNumber) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                    int n2 = sc.nextInt();
                    if(n2 == 2) break;
                }
                else{
                    int strikeCnt = 0; // Strike 확인 메서드
                    int ballCnt = 0; // Ball 확인 메서드
                    for(int i = 0; i < 3; i++) {
                        if(s.charAt(i) == inputStringNumber.charAt(i)) {
                            strikeCnt++;
                        }
                    }
                    for(int i = 0; i < 3; i++) {
                        for(int j = 0; j < 3; j++) {
                            if(i == j) continue;
                            else{
                                if(s.charAt(i) == inputStringNumber.charAt(j)){
                                    ballCnt++;
                                }
                            }
                        }
                    }
                    if(strikeCnt == 0 && ballCnt == 0){
                        System.out.println("낫싱");
                    }
                    else{
                        if(strikeCnt == 0){
                            System.out.println(ballCnt + "볼");
                        }
                        else if(ballCnt == 0) {
                            System.out.println(strikeCnt + "스트라이크");
                        }
                        else{
                            System.out.println(ballCnt +"볼 " + strikeCnt+"스트라이크");
                        }
                    }
                }
            }
        }
    }
}