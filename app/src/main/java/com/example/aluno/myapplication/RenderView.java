package com.example.aluno.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ALUNO on 14/03/2018.
 */

public class RenderView extends View
{
    int r = 200, g = 200, b = 200;

    //Instance para usar no codigo
    ResourceManager resourceManager = ResourceManager.getInstance();

    //Objeto de imagem
    imageGameObject bobImageGObject;

    Paint paint = new Paint();

    public RenderView(Context context)
    {
        super(context);
        //Criando instancia do obj imagem
        bobImageGObject = new imageGameObject();
        //Carregando a imagem
        bobImageGObject.loadImage("bob.png", context.getAssets());
        //Setando posicoes
        bobImageGObject.x = 100;
        bobImageGObject.y = 200;
        //Add a imagem no resource, para controle das layers
        resourceManager.addObject(bobImageGObject);


        animationGameObject anim = new animationGameObject();
        anim.loadImage("spritestank.png",context.getAssets() ,1, 8);
        anim.x = 200;
        anim.y = 200;
        resourceManager.addObject(anim);

        TextGameObject text = new TextGameObject();
        text.text = "Ola";
        text.x = 50;
        text.y = 50;
        resourceManager.addObject(text);
    }



    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRGB(r,g,b);

        for(GameObject obj : resourceManager.gameObjects)
        {
            obj.draw(canvas, paint);
        }
        invalidate();
    }



    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            bobImageGObject.x = (int)event.getX();
            bobImageGObject.y = (int)event.getY();
        }

        return super.onTouchEvent(event);

    }
}
