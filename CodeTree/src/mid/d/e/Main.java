package mid.d.e;


import java.util.*;
import java.io.*;

class Tile {
    public int white = 0;
    public int black = 0;
    public String lastTile;

    public void setLastTile() {
        //System.out.println("isGray 조건문 들어간 횟수");
        this.lastTile = "gray";

    }
}

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tile [] tile = new Tile[n * 100 * 2];
        for(int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
        }
        int point = n * 100 * 2 / 2;
        int b = 0;
        int w = 0;
        int g = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            for(int j = 0; j < x; j++) {
                if ( c == 'R') { //검정색 칠하기
                    if(tile[point].lastTile == "gray") {
                        continue;
                    }
                    else {
                        //System.out.println("black 칠한 횟수");
                        tile[point].lastTile = "black";
                        tile[point].black++;
                        if (tile[point].white >= 2 && tile[point].black >= 2) {
                            tile[point].setLastTile();
                        }
                    }
                    if(j != x -1) {
                        point++;
                    }
                }
                if ( c == 'L') {
                    if(tile[point].lastTile == "gray") {
                        continue;
                    }
                    else {
                        tile[point].lastTile = "white";
                        tile[point].white++;
                        if (tile[point].white >= 2 && tile[point].black >= 2) {
                            tile[point].setLastTile();
                        }
                    }
                    if(j != x -1) {
                        point--;
                    }
                }
            }
        }
        for(int i = 0; i < tile.length; i++) {
            if (tile[i].lastTile == "gray") {
                g++;
            }
            if (tile[i].lastTile == "black") {
                b++;
            }
            if (tile[i].lastTile == "white") {
                w++;
            }
        }
        System.out.println(w + " " + b + " " + g);

    }
}