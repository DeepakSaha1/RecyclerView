package com.example.myapplication;

public class ItemListModel {
    private String mFoodName;
    private String mResAdd;
    private int type; //layout type

    //flag for view check
    public static final int FOOD_NAME_ONLY_TYPE = 0;
    public static final int RES_ADD_ONLY_TYPE = 1;
    public static final int FOOD_NAME_RES_ADD_TYPE = 2;

    public String getmFoodName() {
        return mFoodName;
    }

    public void setmFoodName(String mFoodName) {
        this.mFoodName = mFoodName;
    }

    public String getmResAdd() {
        return mResAdd;
    }

    public void setmResAdd(String mResAdd) {
        this.mResAdd = mResAdd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
