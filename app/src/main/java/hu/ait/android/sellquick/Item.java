package hu.ait.android.sellquick;

public class Item {

    public String hour;
    public String price;
    public String bookName;


    public Item(String bookName, String price, String hour){
        this.bookName = bookName;
        this.price = price;
        this.hour = hour;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPrice(){
        return price;
    }

    public String hour(){
        return hour;
    }
}
