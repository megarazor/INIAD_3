package com.example.singletontest;

import android.graphics.Color;

import static com.example.singletontest.DisplayMode.Default;
import static com.example.singletontest.DisplayMode.Easy;

public class ModeManager {
    private static final ModeManager ourInstance = new ModeManager();
    private DisplayMode mode;
    private int bgColor;
    private int fontColor;
    private float fontSize;
    public static ModeManager getInstance() {
        return ourInstance;
    }
    private ModeManager() {
    }
    public void changeMode(DisplayMode mode) {
        if (mode == Default){
            this.bgColor= Color.WHITE;
            this.fontColor= Color.BLACK;
            this.fontSize= 14;
        }
        else if (mode == Easy){
            this.bgColor= Color.BLACK;
            this.fontColor= Color.WHITE;
            this.fontSize= 30;
        }
    }
    public DisplayMode getMode() {
        return this.mode;
    }
    public int getBgColor() {
        return this.bgColor;
    }
    public int getFontColor() {
        return this.fontColor;
    }
    public float getFontSize() {
        return this.fontSize;
    }
}