package com.code.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
    
        if(n==1) {
            return 0;
        }

        Map<String, String> chessBoard = new HashMap<String, String>();
        chessBoard.put(r_q + "_" + c_q, "Q");
        for (List<Integer> obstacle : obstacles) {
            chessBoard.put(obstacle.get(0) + "_" + obstacle.get(1), "O");
        }

        int movesCount = 0;
    
       // System.out.println("### South Movement ###");
        
        // South Movement
        if (r_q > 1) {
            for (int i = r_q-1; i >= 1; i--) {
                
               // System.out.println(i + "_" + c_q);
                
                if (chessBoard.containsKey(i + "_" + c_q) && chessBoard.get(i + "_" + c_q).equals("O"))
                    break;
                else
                    movesCount++;
            }
        }
        
      //  System.out.println("### North Movement ###");

        // North Movement
        if (r_q < n) {
            for (int i = r_q+1; i <= n; i++) {
                
               // System.out.println(i + "_" + c_q);
                
                if (chessBoard.containsKey(i + "_" + c_q) && chessBoard.get(i + "_" + c_q).equals("O"))
                    break;
                else
                    movesCount++;
            }
        }

       // System.out.println("### West Movement ###");

        // West Movement
        if (c_q > 1) {
            for(int i=c_q-1;i >=1;i--) {
                
             //   System.out.println(r_q + "_" + i);
                
                if (chessBoard.containsKey(r_q + "_" + i) &&  chessBoard.get(r_q + "_" + i).equals("O"))
                    break;
                else
                    movesCount++;
            }
        }
        
        
     //   System.out.println("### East Movement ###");
        //East Movement
        if(c_q < n) {
            for (int i = c_q+1; i <= n; i++) {
                
               // System.out.println(r_q + "_" + i);
                
                if (chessBoard.containsKey(r_q + "_" + i) && chessBoard.get(r_q + "_" + i).equals("O"))
                    break;
                else
                    movesCount++;
            }
        }
        
     //   System.out.println("### North-East Movement ###");
        // North - East - Movement
        int tmpCount = 1;
        if(r_q< n){
        for(int i=r_q+1;i<=n;i++) {
            int row=i;
            int column = c_q+tmpCount;
                if(column <= n){
           // System.out.println(row + "_" + column);
            
            if (chessBoard.containsKey(row + "_" + column) && chessBoard.get(row + "_" + column).equals("O"))
                break;
            else
                movesCount++;
                }
            
            tmpCount++;
        }
        }
       // System.out.println("### North-West Movement ###");
        //North - West - Movement
        tmpCount = 1;
         if(r_q< n ){
        for(int i=r_q+1;i<=n;i++) {
            int row=i;
            int column = c_q-tmpCount;
            
        //    System.out.println(row + "_" + column);
             if(column >= 1){
            if (chessBoard.containsKey(row + "_" + column) && chessBoard.get(row + "_" + column).equals("O"))
                break;
            else
                movesCount++;
             }
            tmpCount--;
        }
         }
        
      //  System.out.println("### South-West Movement ###");
        //South - West - Movement
        tmpCount = 1;
         if(r_q> 1){
        for(int i=r_q-1;i>=1;i--) {
            int row=i;
            int column = c_q-tmpCount;
            
        //    System.out.println(row + "_" + column);
             if(column >= 1){
            if (chessBoard.containsKey(row + "_" + column) && chessBoard.get(row + "_" + column).equals("O"))
                break;
            else
                movesCount++;
             }
            tmpCount++;
        }
         }
        
      //  System.out.println("### South-East Movement ###");
        //South - East - Movement
        tmpCount = 1;
         if(r_q> 1){
        for(int i=r_q-1;i>=1;i--) {
            int row=i;
            int column = c_q+tmpCount;
            
       //     System.out.println(row + "_" + column);
             if(column <= n){
            if (chessBoard.containsKey(row + "_" + column) && chessBoard.get(row + "_" + column).equals("O"))
                break;
            else
                movesCount++;
             }
            tmpCount++;
        }
         }
        
        return movesCount;
    }

}

public class QueenAttack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
