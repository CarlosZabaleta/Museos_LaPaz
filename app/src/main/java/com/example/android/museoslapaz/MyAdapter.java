package com.example.android.museoslapaz;

import android.view.ViewGroup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyPojo> pojos;
    private static RecyclerViewPosition mPositionInterface;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyPojo> pojos, RecyclerViewPosition position) {
        this.pojos = pojos;
        mPositionInterface = position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPositionInterface.getRecyclerViewPosition(this.getAdapterPosition());
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        TextView title = (TextView) holder.view.findViewById(R.id.title);
        TextView desc = (TextView) holder.view.findViewById(R.id.desc);
        ImageView imageView = (ImageView) holder.view.findViewById(R.id.imageView);
        TextView hora = (TextView) holder.view.findViewById(R.id.hora);
        TextView lugar = (TextView) holder.view.findViewById(R.id.lugar);

        title.setText(pojos.get(position).getTitle());
        desc.setText(pojos.get(position).getDesc());
        imageView.setImageResource(pojos.get(position).getImage());
        hora.setText(pojos.get(position).getHora());
        lugar.setText(pojos.get(position).getDir());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pojos.size();
    }
}