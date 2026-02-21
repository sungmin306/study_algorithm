import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N , M;
    public static boolean[] brokenNumbers = new boolean[10]; // 0 ~ 9에서 망가진 숫자 저장

    public static boolean canType(int x) {
        if(x == 0) return !brokenNumbers[x];
        while(x > 0) {
            int tmp = x % 10; // 한자리수씩 확인 1의 자리부터
            if(brokenNumbers[tmp]) return false; // 망가졌으니 누를수 없다는 의미로  false 리턴
            x = x / 10; // 다음 자리 수를 진행하기 위해 숫자 검사한 숫자 빼기
        }
        return true; // 검사 했을때 false 가 안됐으면 다 누를 수 있으니 true 리턴
    }

    public static int digits(int x) {
        if(x == 0) return 1; // x가 0이면 나눌 수 없으니 한자리라고 리턴
        int cnt = 0;
        while(x > 0) { // 자릿수 확인
            cnt++;
            x = x / 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) brokenNumbers[Integer.parseInt(st.nextToken())] = true; // 망가진 숫자들 망가졌다는 의미 true 설정
        }
        if (N == 100) {
            System.out.println(0); // 처음 채널 100에 있는데 100으로 이동하려고 할려면 버튼을 안눌러도 됨
            return; // main함수 종료
        }
        int ans = Math.abs(N - 100); // 모든 숫자가 망가져서 +/- 밖에 누루지 못할 경우

        for(int ch = 0; ch < 999999; ch++) {
            if(!canType(ch)) continue;
            int press = digits(ch) + Math.abs(N - ch);// 다 누를수 있다고 위에서 확인했으니 누르는 횟수(digits(ch)) + +/-로 누르는 횟수(Math.abs(N-ch))
            ans = Math.min(press, ans);
        }
        System.out.println(ans);
    }
}
