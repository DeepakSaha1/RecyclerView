package com.example.myapplication;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ItemListModel> myFoodModelList;
    private FoodItemAdapter foodItemAdapter;
    private boolean isScrolling = false;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerViewContactList = findViewById(R.id.recycler_view_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewContactList.setLayoutManager(layoutManager);
        recyclerViewContactList.setHasFixedSize(true);

        myFoodModelList = new ArrayList<>();
        foodItemAdapter = new FoodItemAdapter(myFoodModelList);

        recyclerViewContactList.setAdapter(foodItemAdapter);

        initData();

        recyclerViewContactList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //total list item
                int totalItems = layoutManager.getItemCount();
                // visible list
                int visibleItems = layoutManager.getChildCount();
                // scrolled out list
                int scrolledOutItems = layoutManager.findFirstVisibleItemPosition();

                if(isScrolling && visibleItems + scrolledOutItems == totalItems) {
                    Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_SHORT).show();
                    isScrolling=false;
                    fetchData();
                }
            }
        });
    }

    //Initilizing Dummy data
    private void initData() {
        ItemListModel itemListModel;
        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch0");
        itemListModel.setmResAdd("Delhi0");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch1");
        itemListModel.setmResAdd("Delhi1");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch2");
        itemListModel.setmResAdd("Delhi2");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch3");
        itemListModel.setmResAdd("Delhi3");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch4");
        itemListModel.setmResAdd("Delhi4");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch5");
        itemListModel.setmResAdd("Delhi5");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch6");
        itemListModel.setmResAdd("Delhi6");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch7");
        itemListModel.setmResAdd("Delhi7");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch8");
        itemListModel.setmResAdd("Delhi8");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch9");
        itemListModel.setmResAdd("Delhi9");
        myFoodModelList.add(itemListModel);
    }


    public void fetchData(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    ItemListModel itemListModel = new ItemListModel();
                    itemListModel.setmFoodName("Buttercotch9");
                    itemListModel.setmResAdd("Delhi9");
                    myFoodModelList.add(itemListModel);
                    foodItemAdapter.notifyDataSetChanged();
                }
            }
        }, 2000);

    }
}
