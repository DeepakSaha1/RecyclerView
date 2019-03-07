package com.example.myapplication.MultipleViewExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.ItemListModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MultipleViewActivity extends AppCompatActivity {
    private List<ItemListModel> itemListModels;
    private MultipleViewAdapter multipleViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        itemListModels = new ArrayList<>();
        multipleViewAdapter = new MultipleViewAdapter(itemListModels);
        recyclerView.setAdapter(multipleViewAdapter);

        initData();
    }

    private void initData() {
        ItemListModel itemListModel;

        for(int i=0; i<5; i++) {
            itemListModel = new ItemListModel();
            itemListModel.setType(ItemListModel.FOOD_NAME_ONLY_TYPE);
            itemListModel.setmFoodName("ButterScotch");
            itemListModels.add(itemListModel);
        }

        for(int i=0; i<5; i++) {
            itemListModel = new ItemListModel();
            itemListModel.setType(ItemListModel.RES_ADD_ONLY_TYPE);
            itemListModel.setmResAdd("Delhi");
            itemListModels.add(itemListModel);
        }

        for(int i=0; i<5; i++) {
            itemListModel = new ItemListModel();
            itemListModel.setType(ItemListModel.FOOD_NAME_RES_ADD_TYPE);
            itemListModel.setmFoodName("Caremel");
            itemListModel.setmResAdd("Noida");
            itemListModels.add(itemListModel);
        }
    }
}
