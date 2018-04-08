package hu.ait.android.sellquick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Books extends AppCompatActivity {
    public Button butt2;
    public Button butt3;
    public EditText bookName;
    public EditText price;

    public void addBook(View view){
        butt3 = (Button)findViewById(R.id.butt3);
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addAnItem = new Intent(Books.this, addItem.class);
                startActivity(addAnItem);

            }
        });
    }

    public void init(){
        butt2 = (Button)findViewById(R.id.butt2);
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity = new Intent(Books.this, MainActivity.class);
                startActivity(MainActivity);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        init();
    }
}

