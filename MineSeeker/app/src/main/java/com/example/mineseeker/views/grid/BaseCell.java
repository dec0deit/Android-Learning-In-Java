package com.example.mineseeker.views.grid;

import android.content.Context;
import android.view.View;

import com.example.mineseeker.GameEngine;

public abstract class BaseCell extends View {

    private int val;
    private boolean isBomb;
    private boolean isClicked;
    private boolean isFlagged;
    private  boolean isRevealed;
    private  int x,y;
    private int position;
    public BaseCell(Context context) {
        super(context);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        isBomb=false;
        isRevealed=false;
        isClicked=false;
        isFlagged=false;
        if(val==-1){
            isBomb=true;
        }
        this.val = val;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        isClicked = true;
        this.isRevealed=true;
        invalidate();
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public int getXPos() {
        return x;
    }


    public int getYPos() {
        return y;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        x=position% GameEngine.WIDTH;
        y=position%GameEngine.HEIGHT;
    }
}
