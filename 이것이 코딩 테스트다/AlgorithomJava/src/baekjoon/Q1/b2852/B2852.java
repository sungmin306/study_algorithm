package baekjoon.Q1.b2852;

import java.util.*;
import java.io.*;

public class B2852 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 0;
        int score = 0;
        int teamA = 0;
        int teamB = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int win = Integer.parseInt(st.nextToken());
            String[] times = st.nextToken().split("\\D");
            int secondTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            if(score > 0) teamA += secondTime - time;
            if(score < 0) teamB += secondTime - time;
            if(win == 1) score++;
            else if(win == 2) score--;
            time = secondTime;
        }
        if(score > 0) teamA += 48 * 60 - time;
        if(score < 0) teamB += 48 * 60 - time;
        System.out.printf("%02d:%02d",teamA/60,teamA%60);
        System.out.println();
        System.out.printf("%02d:%02d",teamB/60,teamB%60);




    }
}
