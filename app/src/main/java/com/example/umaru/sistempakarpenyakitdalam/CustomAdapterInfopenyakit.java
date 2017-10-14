package com.example.umaru.sistempakarpenyakitdalam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterInfopenyakit extends RecyclerView.Adapter<CustomAdapterInfopenyakit.MyViewHolder> {

    private ArrayList<InfopenyakitModel> dataSet;
    Boolean check=false;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView namapenyakit,deskripsi,solution;
        RelativeLayout expandable;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.expandable= (RelativeLayout)itemView.findViewById(R.id.expandableLayout);
            this.namapenyakit= (TextView)itemView.findViewById(R.id.namapenyakitText);
            this.deskripsi = (TextView) itemView.findViewById(R.id.deskripsiText);
            this.solution = (TextView) itemView.findViewById(R.id.solutiontext);
        }
    }

    public CustomAdapterInfopenyakit(ArrayList<InfopenyakitModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row_infopenyakit, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check)
                {
                    myViewHolder.expandable.animate()
                            .alpha(0.0f)
                            .setDuration(1000);

                    myViewHolder.expandable.setVisibility(View.GONE);
                        check=true;


                }
                else {
                    myViewHolder.expandable.setVisibility(View.VISIBLE);
                    myViewHolder.expandable.animate()
                            .alpha(1.0f)
                            .setDuration(1000);

                    check=false;

                }
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView namapenyakit1= holder.namapenyakit;
        TextView deskripsi1 = holder.deskripsi;
        TextView solution1 = holder.solution;

        namapenyakit1.setText(dataSet.get(listPosition).getNamapenyakit());
        deskripsi1.setText(dataSet.get(listPosition).getDeskripsi());
        solution1.setText(dataSet.get(listPosition).getSolution());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}