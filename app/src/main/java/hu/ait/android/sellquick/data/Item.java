package hu.ait.android.sellquick.data;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by zhaozhaoxia on 4/7/18.
 */

public class Item extends RealmObject implements Parcelable{
    @PrimaryKey
    private String itemID;

    private String itemName;
    //private String SellerName;
    private float price;
    private int countDown;

    public Item(){}

    public Item(String itemName, float price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    protected Item(Parcel in) {
        itemID = in.readString();
        itemName = in.readString();

        price = in.readFloat();
        countDown = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(itemID);
        parcel.writeString(itemName);
        parcel.writeFloat(price);
        parcel.writeInt(countDown);
    }
}
