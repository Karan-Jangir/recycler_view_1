package com.example.recycler_view_1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_view_1.R;
import com.example.recycler_view_1.model.model_1;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapter_1 extends RecyclerView.Adapter<adapter_1.viewHolder>
{

    ArrayList<model_1> list;
    Context context;

    public adapter_1(ArrayList<model_1> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.sample_recycler_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        model_1 md=list.get(position);
        holder.imageView.setImageResource(md.getPicture());
        holder.textView.setText(md.getTxt());

        switch(position)
        {
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Image one is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Textview one is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Image two is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Textview two is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            default:
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.text_1);
        }
    }
}

