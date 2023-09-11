package chapter12;
import java.util.*;
public class Q10 {

    public static int[][] rotateMatrixBy900Degree(int[][] a) {  // 2차원 리스트 90도 로 회전
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n-i-1] = a[i][j];
            }
        }
        return result;
    }

    public static boolean check(int[][] newLock) { // 값이 다 1인지 체크하는 함수
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        int[][] newLock = new int[n * 3][n * 3]; // newLock = 기존 lock의 3배짜리 Lock 만들기

        for (int i = 0; i < n; i++) {  // 가운데에 Lock 값을 대입
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int rocation = 0; rocation < 4; rocation++) {  // 방향 전환 4번
            key = rotateMatrixBy900Degree(key);  // 90도 방향전환
            for(int x= 0; x < n * 2; x ++) { // newLock 크기 때문에 들어간 반복문
                for(int y = 0; y < n * 2; y++){ // newLock 크기 때문에 들어간 반복문
                    for (int i = 0; i < m; i++) {  // key 값을 newLock에 대입하는 반복문
                        for (int j = 0; j < m; j++) { // key 값을 newLock에 대입하는 반복문
                            newLock[x + i][y + i] += key[i][j];
                        }
                    }
                    if (check(newLock)) return true;

                    for (int i = 0; i < m; i++) {  // 값을 비교해준 후에 다시 원상복귀
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] key = new int[20][20];
        int[][] lock = new int[20][20];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                key[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                key[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(key, lock));
    }
}

