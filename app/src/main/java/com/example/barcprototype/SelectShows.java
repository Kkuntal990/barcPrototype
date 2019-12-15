package com.example.barcprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class SelectShows extends AppCompatActivity {
    protected RecyclerView recyclerView;
    protected MyAdapter mAdapter;
    protected RecyclerView.LayoutManager layoutManager;
    private Button nextBtn;
    private String[] mDataset;
    private int image = R.drawable.img_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_shows);
        initDataset();
        recyclerView = (RecyclerView) findViewById(R.id.list_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mDataset, image);
        recyclerView.setAdapter(mAdapter);
        nextBtn = (Button) findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(SelectShows.this, Remote.class));
                questionsFragment mFragment = new questionsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout_questions1, mFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }



    private void initDataset() {

        mDataset = new String[10];
        for (int i =0; i < 10; i++) {
            mDataset[i] = "Cars " + i;
        }
    }
}
