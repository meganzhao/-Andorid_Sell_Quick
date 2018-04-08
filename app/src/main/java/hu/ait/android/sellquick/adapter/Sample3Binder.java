package hu.ait.android.sellquick.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;

import hu.ait.android.sellquick.R;

/**
 * Created by zhaozhaoxia on 4/8/18.
 */

public class Sample3Binder extends DataBinder<Sample3Binder.ViewHolder> {
    public Sample3Binder(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_sample3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.mImageView.getContext())
                .load(R.drawable.shoes)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleText;
        ImageView mImageView;
        TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mTitleText = (TextView) view.findViewById(R.id.title_type3);
            mImageView = (ImageView) view.findViewById(R.id.image_type3);
            mContent = (TextView) view.findViewById(R.id.content_type3);
        }
    }
}
