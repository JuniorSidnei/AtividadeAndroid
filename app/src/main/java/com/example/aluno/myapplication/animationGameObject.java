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

public class animationGameObject extends GameObject
{
    //Array de para carregar imagens
    Bitmap anim[];
    //O nome da variável ja diz né
    int totalframes, mainFrame = 0;
    float startTime = 0;

    @Override
    public void draw(Canvas canvas, Paint paint)
    {
        super.draw(canvas, paint);
        float elapseTime = (System.nanoTime()-startTime) / 1000000;
        if (elapseTime > 200)
        {
            startTime = System.nanoTime();
            mainFrame ++;
            if (mainFrame >= totalframes)
                mainFrame = 0;
        }


        canvas.drawBitmap(anim[mainFrame],x,y,paint);
    }

    //Carregar uma imagem
    public void loadImage(String imageName, AssetManager manager, int frameW, int frameH)
    {
        try
        {
            InputStream inputStream = manager.open(imageName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            //Frames totais da imagem
            totalframes = frameW * frameH;
            //Instanciando o array com o total de frames da imagem
            anim = new Bitmap[totalframes];

            //Mesma porra do openframw bleeeeeh blheeeh works
            int width = bitmap.getWidth() / frameW;
            int height = bitmap.getHeight() / frameH;

            int index = 0;

            for(int j = 0; j < frameH; j++)
            {
                for(int i = 0; i < frameW; i++)
                {
                        anim[index++] = Bitmap.createBitmap(bitmap, i*width, j*height, width, height);
                }
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
