package com.example.android.museoslapaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class informacion_museo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_museo);
        String indice = "";
        String arrayHora[] = getResources().getStringArray(R.array.times);
        String arrayTitulo[] = getResources().getStringArray(R.array.tituloLugar);
        String arrayDescripcion[] = getResources().getStringArray(R.array.descripcion);
        String arrayLugar[] = getResources().getStringArray(R.array.lugar);
        int image[] = {R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i,
                R.drawable.i2, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,
                R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z,
                R.drawable.za, R.drawable.zb, R.drawable.zc, R.drawable.zd, R.drawable.ze, R.drawable.zf,
                R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj};

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                indice = extras.getString("titulo");
                int i = Integer.parseInt(indice);
                TextView tv1 = (TextView) findViewById(R.id.title);
                tv1.setText(arrayTitulo[i]);
                TextView tv2 = (TextView) findViewById(R.id.hora);
                tv2.setText(arrayHora[i]);
                TextView tv3 = (TextView) findViewById(R.id.lugar);
                tv3.setText(arrayLugar[i]);
                TextView tv4 = (TextView) findViewById(R.id.desc);
                tv4.setText(arrayDescripcion[i]);
                ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                imageView.setImageResource(image[i]);
            }
        }
    }

    public void volver(View view) {
        finish();
    }
}