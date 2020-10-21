package com.example.mineseeker.util;

public class PrintGrid {

    public static void print(final int[][] grid,final int height,final int width){
        for(int i=0;i<width;i++){
            String temp=" | ";
            for(int j=0;j<height;j++){
                temp+=String.valueOf(grid[i][j])+" ";
            }
            System.out.println(temp);
        }
    }
}
