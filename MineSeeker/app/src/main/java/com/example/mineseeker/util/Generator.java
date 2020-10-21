package com.example.mineseeker.util;

import java.util.Random;

public class Generator {

    public static int [][] generate(int bombnumber,final int width,final int height){
        Random r=new Random();
        int [][] grid =new int[width][height];
        for(int i=0;i<width;i++){
            grid[i]=new int[height];
        }
        while(bombnumber>0){
            int x=r.nextInt(width);
            int y=r.nextInt(height);
            if(grid[x][y]!=-1){
                grid[x][y]=-1;
                bombnumber--;
            }
        }
        grid=calculateNeigbours(grid,width,height);
        return grid;
    }
    private static int [][] calculateNeigbours(int [][] grid,final int width,final int height){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                grid[i][j]=getNeighbourNumber(grid,i,j,width,height);
            }
        }
        return grid;
    }
    private static int getNeighbourNumber(final int grid[][],final int x,final int y,final int width,final int height){
        if(grid[x][y]==-1){
            return -1;
        }
        int count=0;
        if(isMineAr(grid,x-1,y,width,height)){
            count++;
        }
        if(isMineAr(grid,x,y-1,width,height)){
            count++;
        }if(isMineAr(grid,x+1,y,width,height)){
            count++;
        }if(isMineAr(grid,x,y+1,width,height)){
            count++;
        }if(isMineAr(grid,x+1,y+1,width,height)){
            count++;
        }
        if(isMineAr(grid,x-1,y-1,width,height)){
            count++;
        }if(isMineAr(grid,x-1,y+1,width,height)){
            count++;
        }if(isMineAr(grid,x+1,y-1,width,height)){
            count++;
        }
        return count;
    }
    private static boolean isMineAr(final int [][] grid,final int x,final int y,final int width,final int height){
        if(x>=0 && y>=0 && x<width && y<height){
            if(grid[x][y]==-1){
                return true;
            }
        }
        return false;
    }
}
