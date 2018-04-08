package hu.ait.android.sellquick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.sellquick.adapter.SampleEnumListAdapter;
import hu.ait.android.sellquick.data.SampleData;

public class MyitemsActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myitems1);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_myItems);
        SampleEnumListAdapter adapter = new SampleEnumListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SampleData> sampleData = getSampleData();
        adapter.setSample1Data(sampleData);
    }

    private List<SampleData> getSampleData() {
        List<SampleData> dataSet = new ArrayList<>();

        SampleData data = new SampleData();
        //data.mTitle = getString(R.string.title_type1);
        data.mTitle = "title1";
        data.mDrawableResId = getResources().getIdentifier(
                getString(R.string.img_book), "drawable", getPackageName());
        //data.mContent = getString(R.string.content_type2, i);
        data.mContent = "content1";
        dataSet.add(data);

        return dataSet;
    }
}
