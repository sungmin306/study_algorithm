package baekjoon.direct.b2852;

import java.io.*;
import java.util.*;


public class B2852 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        int time = 0;
        int teamA = 0;
        int teamB = 0;
        int n = Integer.parseInt(br.readLine());
        boolean check;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNumber = Integer.parseInt(st.nextToken());
            if(teamNumber == 1) check = true;
            else check = false;
            String[] team = st.nextToken().split(":");
            int second = Integer.parseInt(team[0]) * 60 + Integer.parseInt(team[1]);
            if(score > 0) teamA += second - time;
            if(score < 0) teamB += second - time;
            if(check) score+= 1;
            else score -= 1;
            time = second;
        }
        if(score > 0) teamA += 2880 - time;

        if(score < 0) teamB += 2880 - time;
        System.out.printf("%02d:%02d",teamA/60,teamA%60);
        System.out.println();
        System.out.printf("%02d:%02d",teamB/60,teamB%60);

    }
}


