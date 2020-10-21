package com.example.mineseeker;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.mineseeker.util.Generator;
import com.example.mineseeker.util.PrintGrid;
import com.example.mineseeker.views.grid.Cell;

public class GameEngine {

    public static GameEngine instance;

    public static final int BOMB_NUMBER=10;
    public static final int WIDTH=4;
    public static final int HEIGHT=4;
    private Context context;

    private Cell[][] MineSeekerGrid=new Cell[WIDTH][HEIGHT];
    public static GameEngine getInstance(){

        if(instance==null){
            instance=new GameEngine();
        }
        Log.e("created  Instance","game");
        return instance;
    }
   private GameEngine(){

   }

   public void createGrid(Context context){
        this.context=context;

        int [][] GeneratedGrid= Generator.generate(BOMB_NUMBER,WIDTH,HEIGHT);
        PrintGrid.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
   }

   private void setGrid(final Context context,final int[][] grid){
        for(int x=0;x<WIDTH;x++){
            for(int y=0;y<HEIGHT;y++){
                if(MineSeekerGrid[x][y]==null){
                    MineSeekerGrid[x][y]=new Cell(context,x*HEIGHT+y);
                }
                MineSeekerGrid[x][y].setVal(grid[x][y]);
                MineSeekerGrid[x][y].invalidate();
            }
        }
   }
    public Cell getCellAt(int x,int y){
        return MineSeekerGrid[x][y];
    }
   public void click(int posX,int posY){
        if(posX>=0 && posY>=0 && posX<WIDTH && posY<HEIGHT && getCellAt(posX,posY).isClicked()){
                getCellAt(posX,posY).setClicked();
                if(getCellAt(posX,posY).getVal()==0){
                    for(int xt=-1;xt<=1;xt++){
                        for(int yt=-1;yt<=1;yt++){
                            if(xt!=yt ){
                                click(posX+xt,posY+yt);
                            }
                        }
                    }
                 }
                if(getCellAt(posX,posY).isBomb()){
                    onGameLost();
                }
        }
   }
        public void onGameLost(){

        }

    public Cell getCellAt(int position) {
        int x=position%WIDTH;
        int y=position%HEIGHT;
        return MineSeekerGrid[x][y];
    }

    public void flag(int xPos, int yPos) {
        boolean isFlagged=getCellAt(xPos,yPos).isFlagged();
        getCellAt(xPos,yPos).setFlagged(!isFlagged);
        getCellAt(xPos,yPos).invalidate();
    }
}
