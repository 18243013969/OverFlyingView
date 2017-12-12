package com.renny.contractgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.renny.contractgridview.recyclerview.ItemAdapter;
import com.renny.contractgridview.recyclerview.OverFlyingLayoutManager;

import java.util.ArrayList;

public class VertialActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertial);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        OverFlyingLayoutManager layoutManager = new OverFlyingLayoutManager(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setViewEdgeListener(new OverFlyingLayoutManager.viewEdgeListener() {
            @Override
            public void onTop(View view, float offsetPercent) {
                Log.d("bbbb", "onTop  " + offsetPercent);
                CardView cardView = view.findViewById(R.id.card_view);
                //cardView.setCardElevation(10);
            }

            @Override
            public void onBottom(View view, float offsetPercent) {
                Log.d("bbbb", "onBottom  " + offsetPercent);
            }
        });
        //构建一个临时数据源
        for (int i = 0; i < 16; i++) {
            items.add("Item:第" + i + "项");
        }
        mAdapter = new ItemAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListerer(new ItemAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view) {
                Toast.makeText(VertialActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
