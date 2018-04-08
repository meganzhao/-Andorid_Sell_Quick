package hu.ait.android.sellquick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addItem extends AppCompatActivity {

    public Button butt4;
    public Button butt5;
    public EditText hour;
    public EditText price;
    public EditText bookName;

    public void toList(View view){

        EditText bookName = (EditText) findViewById(R.id.enterItem);
        EditText price = (EditText) findViewById(R.id.price);
        EditText hour = (EditText) findViewById(R.id.hour);

        Log.i("bookInfo", bookName.getText().toString());
        Log.i("priceInfo", price.getText().toString());
        Log.i("hours", hour.getText().toString());


        butt5 = (Button)findViewById(R.id.butt5);
        butt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBooks = new Intent(addItem.this, Books.class);
                startActivity(toBooks);

            }
        });

    }

    public void init(){
        butt4 = (Button)findViewById(R.id.butt4);
        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookss = new Intent(addItem.this, Books.class);
                startActivity(bookss);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        init();
    }
}
