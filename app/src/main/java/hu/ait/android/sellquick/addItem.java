package hu.ait.android.sellquick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addItem extends AppCompatActivity {

    public Button butt4;
    public Button butt5;
    public EditText hour;
    public EditText price;
    public EditText bookName;


    DatabaseReference databaseItem;

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

        databaseItem = FirebaseDatabase.getInstance().getReference("item");

        bookName = (EditText) findViewById(R.id.enterItem);
        price = (EditText) findViewById(R.id.price);
        hour = (EditText) findViewById(R.id.hour);


        init();
    }

    public void toList(View view){

        String bookName1 = bookName.getText().toString().trim();
        String price1 = price.getText().toString();
        String hour1 = hour.getText().toString();

        String id = databaseItem.push().getKey();

        Item item = new Item(bookName1, price1, hour1);
        databaseItem.child(id).setValue(item);

        Toast.makeText(this,"item added", Toast.LENGTH_LONG).show();
        Intent bookss = new Intent(addItem.this, Books.class);
        startActivity(bookss);

        butt5 = (Button)findViewById(R.id.butt5);
        butt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBooks = new Intent(addItem.this, Books.class);
                startActivity(toBooks);

            }
        });

    }
}