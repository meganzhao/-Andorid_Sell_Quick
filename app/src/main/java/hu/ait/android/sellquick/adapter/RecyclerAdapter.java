package hu.ait.android.sellquick.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

import hu.ait.android.sellquick.R;
import hu.ait.android.sellquick.data.Item;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by zhaozhaoxia on 4/7/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item> itemList;
    private Realm realmItem;
    private Context context;
    int[] color_arr={Color.parseColor("#90CAF9"),Color.parseColor("#81D4FA"),Color.parseColor("#80DEEA"),
            Color.parseColor("#4DD0E1"),Color.parseColor("#4FC3F7"),Color.parseColor("#64B5F6"),
            Color.parseColor("#26C6DA"),Color.parseColor("#29B6F6"),Color.parseColor("#42A5F5")};
    int colorIndex = -1;

    public RecyclerAdapter(Realm realmItem, Context context) {
        this.itemList = new ArrayList<Item>();
        this.realmItem = realmItem;
        this.context = context;
        RealmResults<Item> itemResult = realmItem.where(Item.class).findAll().sort("countDown", Sort.ASCENDING);
        for (Item item: itemResult){
            itemList.add(item);
        }
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        colorIndex = (colorIndex + 1) % 9;
        itemRow.setBackgroundColor(color_arr[colorIndex]);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item cityWeatherData = itemList.get(position);
        final int removePosition = position;
        holder.tvItemName.setText(cityWeatherData.getItemName());

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAt(removePosition);
            }
        });
    }

    public void removeAt(int position){
        Item toRemoveObject = itemList.get(position);
        realmItem.beginTransaction();
        toRemoveObject.deleteFromRealm();
        realmItem.commitTransaction();
        itemList.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(String itemName, Float itemPrice){
        realmItem.beginTransaction();

        Item newItem = realmItem.createObject(Item.class, UUID.randomUUID().toString());
        newItem.setItemName(itemName);
        newItem.setPrice(itemPrice);

        realmItem.commitTransaction();
        itemList.add(newItem);
        notifyItemInserted(itemList.size());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItemName;
        private TextView tvCountDown;
        private ImageView ivDelete;
        public ViewHolder(View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvCountDown = itemView.findViewById(R.id.tvCountDown);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }
}
