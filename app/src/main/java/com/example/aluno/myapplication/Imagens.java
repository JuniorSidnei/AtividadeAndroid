package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Imagens extends AppCompatActivity
{
    //Render usado para mostrar o que acontece na tela
    RenderView renderView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();

        //opt para esconder as barras do app e deixar fullscreen
        int opt = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        decorView.setSystemUiVisibility(opt);
        //Esconder a barra com o nome do app
        getSupportActionBar().hide();

        //Deixando a tela com o que será mostrado
        renderView = new RenderView(this);
        setContentView(renderView);
    }
}
