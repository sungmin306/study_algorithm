package chapter12;
import java.io.*;
import java.util.*;
public class yb {


        public static void main (String[] args) {
            int[][] dim_arr = {{10, 11, 12, 13, 14}, {20, 21, 22}, {30, 31, 32, 33}, {40}, {50, 51}};
            for(int i=0; i<5; i++){
                for(int j=0; j<dim_arr[i].length; j++){
                    System.out.print(dim_arr[i][j] + " ");
                }
                System.out.println();
            }
        }


}
