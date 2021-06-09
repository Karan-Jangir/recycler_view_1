package com.example.recycler_view_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycler_view_1.adapters.adapter_1;
import com.example.recycler_view_1.classes.RecyclerItemClickListener;
import com.example.recycler_view_1.model.model_1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        ArrayList<model_1> list= new ArrayList<>();

        list.add(new model_1(R.drawable.mi,"Mumbai Indians"));
        list.add(new model_1(R.drawable.csk,"Chennai Super Kings"));
        list.add(new model_1(R.drawable.rcbb,"Royal Challengers Bangalore"));
        list.add(new model_1(R.drawable.dc,"Delhi Capital  s"));
        list.add(new model_1(R.drawable.srh,"Sunrisers Hyderabad"));
        list.add(new model_1(R.drawable.kkr,"Kolkata Knight Riders"));
        list.add(new model_1(R.drawable.pbks,"Punjab Kings"));
        list.add(new model_1(R.drawable.rr,"Rajasthan Royals"));

        adapter_1 ad=new adapter_1(list,this);
        recyclerView.setAdapter(ad);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch(position) {
                    case 0:
                        Intent intent =new Intent(MainActivity.this,ScrollingActivity.class);
                        startActivity(intent);

                        break;
                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {


                switch(position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Long press", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                }
            }
        }));

//        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(layoutManager);

//        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,3);
//        recyclerView.setLayoutManager(gridLayoutManager);

        StaggeredGridLayoutManager std= new StaggeredGridLayoutManager(3,LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(std);
    }
}