package hu.ait.android.sellquick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import hu.ait.android.sellquick.adapter.RecyclerAdapter;
import hu.ait.android.sellquick.data.Item;

public class MyitemsActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myitems);

        ((ItemApplication)getApplication()).openRealm();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvList);
        adapter = new RecyclerAdapter(((ItemApplication)getApplication()).getRealm(),this
                );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    protected void onDestory(){
        ((ItemApplication)getApplication()).closeRealm();
        super.onDestroy();
    }
}
