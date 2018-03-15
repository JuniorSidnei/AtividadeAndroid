package com.example.aluno.myapplication;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALUNO on 14/03/2018.
 */

public class imageGameObject extends GameObject
{
    Bitmap bitmap;

    @Override
    public void draw(Canvas canvas, Paint paint)
    {
        super.draw(canvas, paint);
        canvas.drawBitmap(bitmap,x,y,paint);
    }

    //Carregar uma imagem
    public void loadImage(String imageName, AssetManager manager)
    {
        try
        {
            InputStream inputStream = manager.open(imageName);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
