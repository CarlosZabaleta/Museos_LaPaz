package com.example.android.museoslapaz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewPosition {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
        // Get the string array
        String[] countries = getResources().getStringArray(R.array.tituloLugar);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<MyPojo> pojos = new ArrayList<MyPojo>();

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
        for (int i = 0; i < arrayTitulo.length; i++) {
            pojos.add(new MyPojo(
                    arrayTitulo[i],
                    arrayDescripcion[i],
                    image[i],
                    arrayHora[i],
                    arrayLugar[i]
            ));
        }

        mAdapter = new MyAdapter(pojos, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void getRecyclerViewPosition(int position) {
        Intent intent = new Intent(this, informacion_museo.class);
        //TextView textView = (TextView) findViewById(R.id.title);
        String posicion = Integer.toString(position);
        intent.putExtra("titulo", posicion);
        startActivity(intent);
    }
}