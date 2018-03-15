package com.example.aluno.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ALUNO on 14/03/2018.
 */

public class TextGameObject extends GameObject
{
    int color = Color.BLACK;
    int size = 50;
    String text = "";

    @Override
    public void draw(Canvas canvas, Paint paint)
    {
        super.draw(canvas, paint);
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(text, x,y,paint);
    }
}
