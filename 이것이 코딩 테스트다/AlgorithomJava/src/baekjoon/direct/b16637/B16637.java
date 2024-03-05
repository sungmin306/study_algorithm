package baekjoon.direct.b16637;

import java.util.*;
import java.io.*;
public class B16637 {

    public static int n;
    public static ArrayList<Character> operators;
    public static ArrayList<Integer> numbers;
    public static int result;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        operators = new ArrayList<>();
        numbers = new ArrayList<>();
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                numbers.add(s.charAt(i) - '0');
            }
            else {
                operators.add(s.charAt(i));
            }
        }
        result = Integer.MIN_VALUE;
//        System.out.println("operator" + operators.toString());
//        System.out.println("numbers" + numbers.toString());
        dfs(numbers.get(0),0);
        System.out.println(result);
    }
    public static void dfs(int num, int index) {

        if(index >= operators.size()) {
            result = Math.max(result, num);
            //System.out.println("result" + result);
            return;
        }

        System.out.println(num);
        System.out.println(operators.get(index));
        System.out.println(numbers.get(index +1));

        int res1 = calculator(operators.get(index), num, numbers.get(index + 1));
        dfs(res1, index +1);

        if(index + 1 < operators.size()) { // 처음계산했을때를 제거

            System.out.println(operators.get(index+1));
            System.out.println(numbers.get(index + 1));
            System.out.println(numbers.get(index + 2));
            int res2 = calculator(operators.get(index +1), numbers.get(index +1), numbers.get(index + 2)); // 뒤에 값부터 괄호 묶어서 계산
            dfs(calculator(operators.get(index), num, res2), index + 2);
        }


    }

    public static int calculator(char op, int num1, int num2) {
        if(op == '+') return num1 + num2;
        if(op == '-') return num1 - num2;
        if(op == '*') return num1 * num2;
        return -1;
    }
}
