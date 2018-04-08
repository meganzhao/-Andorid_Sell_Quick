package hu.ait.android.sellquick.adapter;

import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumListBindAdapter;

import java.util.List;

import hu.ait.android.sellquick.data.SampleData;

/**
 * Created by zhaozhaoxia on 4/8/18.
 */

public class SampleListAdapter extends EnumListBindAdapter<SampleListAdapter.SampleViewType> {
    enum SampleViewType {
        SAMPLE2
    }

    public SampleListAdapter() {
        addAllBinder(
                new Sample2Binder(this));
    }

    public void setSample2Data(List<SampleData> dataSet) {
        ((Sample2Binder) getDataBinder(SampleListAdapter.SampleViewType.SAMPLE2)).addAll(dataSet);
    }
}
