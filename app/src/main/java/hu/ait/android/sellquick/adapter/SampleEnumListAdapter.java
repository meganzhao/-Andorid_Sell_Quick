package hu.ait.android.sellquick.adapter;

import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumListBindAdapter;

import java.util.List;

import hu.ait.android.sellquick.data.SampleData;

/**
 * Created by zhaozhaoxia on 4/8/18.
 */

public class SampleEnumListAdapter extends EnumListBindAdapter<SampleEnumListAdapter.SampleViewType> {

    enum SampleViewType {
        SAMPLE1, SAMPLE2, SAMPLE3
    }

    public SampleEnumListAdapter() {
        addAllBinder(new Sample1Binder(this),
                new Sample2Binder(this),
                new Sample3Binder(this));
    }

    public void setSample1Data(List<SampleData> dataSet) {
        ((Sample2Binder) getDataBinder(SampleViewType.SAMPLE2)).addAll(dataSet);
    }
}
