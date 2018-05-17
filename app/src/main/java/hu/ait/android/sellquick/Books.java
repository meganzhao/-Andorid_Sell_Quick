package hu.ait.android.sellquick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.sellquick.adapter.SampleEnumListAdapter;
import hu.ait.android.sellquick.adapter.SampleListAdapter;
import hu.ait.android.sellquick.data.SampleData;

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
    public void backToMain(View view){
        butt2 = (Button)findViewById(R.id.butt2);
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Books.this, MainActivity.class);
                startActivity(back);

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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_books);
        SampleListAdapter adapter = new SampleListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SampleData> sampleData = getSampleData();
        adapter.setSample2Data(sampleData);

        init();


    }

    private List<SampleData> getSampleData() {
        List<SampleData> dataSet = new ArrayList<>();

        SampleData data = new SampleData();
        //data.mTitle = getString(R.string.title_type1);
        data.mTitle = "$3";
        data.mDrawableResId = getResources().getIdentifier(
                getString(R.string.img_book2), "drawable", getPackageName());
        //data.mContent = getString(R.string.content_type2, i);
        data.mContent = "Intro to CS textbook";
        dataSet.add(data);

        SampleData data2 = new SampleData();
        //data.mTitle = getString(R.string.title_type1);
        data2.mTitle = "For Free!";
        data2.mDrawableResId = getResources().getIdentifier(
                getString(R.string.img_book), "drawable", getPackageName());
        //data.mContent = getString(R.string.content_type2, i);
        data2.mContent = "Walden by Henry David Thoreau";
        dataSet.add(data2);

        SampleData data3 = new SampleData();
        //data.mTitle = getString(R.string.title_type1);
        data3.mTitle = "$5";
        data3.mDrawableResId = getResources().getIdentifier(
                getString(R.string.img_book4), "drawable", getPackageName());
        //data.mContent = getString(R.string.content_type2, i);
        data3.mContent = "All the books for Native American religious freedom";
        dataSet.add(data3);

        SampleData data4 = new SampleData();
        //data.mTitle = getString(R.string.title_type1);
        data4.mTitle = "$5";
        data4.mDrawableResId = getResources().getIdentifier(
                getString(R.string.img_book3), "drawable", getPackageName());
        //data.mContent = getString(R.string.content_type2, i);
        data4.mContent = "Data Structure textbook";
        dataSet.add(data4);

        return dataSet;
    }

}

