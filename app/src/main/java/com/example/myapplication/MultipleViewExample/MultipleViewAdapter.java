package com.example.myapplication.MultipleViewExample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.ItemListModel;
import com.example.myapplication.R;

import java.util.List;

public class MultipleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ItemListModel> itemListModels;

    public MultipleViewAdapter(List<ItemListModel> itemListModels) {
        this.itemListModels = itemListModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == ItemListModel.FOOD_NAME_ONLY_TYPE) {
            return new OnlyFoodNameViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_list_name_only, viewGroup, false));
        } else if (viewType == ItemListModel.RES_ADD_ONLY_TYPE) {
            return new OnlyResAddViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_list_res_add_only, viewGroup, false));
        } else {
            return new ResAddFoodNameViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_list_name_add, viewGroup, false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ItemListModel itemListModel = itemListModels.get(position);
        if(viewHolder instanceof OnlyFoodNameViewHolder) {
            ((OnlyFoodNameViewHolder) viewHolder).mFoodname.setText(itemListModel.getmFoodName());
        } else if (viewHolder instanceof OnlyResAddViewHolder) {
            ((OnlyResAddViewHolder) viewHolder).mResAdd.setText(itemListModel.getmResAdd());
        } else {
            ((ResAddFoodNameViewHolder) viewHolder).mFoodname.setText(itemListModel.getmFoodName());
            ((ResAddFoodNameViewHolder) viewHolder).mResAdd.setText(itemListModel.getmResAdd());
        }
    }

    @Override
    public int getItemCount() {
        return itemListModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemListModels.get(position).getType();
    }

    class OnlyFoodNameViewHolder extends RecyclerView.ViewHolder {
        TextView mFoodname;
        public OnlyFoodNameViewHolder(@NonNull View itemView) {
            super(itemView);
            mFoodname = itemView.findViewById(R.id.food_name_tv);
        }
    }

    class OnlyResAddViewHolder extends RecyclerView.ViewHolder {
        TextView mResAdd;
        public OnlyResAddViewHolder(@NonNull View itemView) {
            super(itemView);
            mResAdd = itemView.findViewById(R.id.res_add_tv);
        }
    }

    class ResAddFoodNameViewHolder extends RecyclerView.ViewHolder {
        TextView mFoodname;
        TextView mResAdd;
        public ResAddFoodNameViewHolder(@NonNull View itemView) {
            super(itemView);
            mFoodname = itemView.findViewById(R.id.iv_FOOD);
            mResAdd = itemView.findViewById(R.id.Address_IV);
        }
    }
}
