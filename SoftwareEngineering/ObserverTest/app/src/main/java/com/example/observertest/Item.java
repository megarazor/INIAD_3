package com.example.observertest;

import android.graphics.Color;
import android.widget.Button;

public class Item implements Observer {
    private Button btn;

    public Item(String label, Button btn){
        this.btn= btn;
        btn.setText(label);
    }

    @Override
    public void update(LightManager lightManager){
        LightMode mode= lightManager.getLightMode();
        switch(mode){
            case FULL:
                btn.setText("FULL");
                btn.setBackgroundColor(Color.RED);
                break;
            case DIM:
                btn.setText("DIM");
                btn.setBackgroundColor(Color.YELLOW);
                break;
            case OFF:
                btn.setText("OFF");
                btn.setBackgroundColor(Color.GRAY);
                break;
        }
    }
}
