package com.steventxc.example.abstractwrapadaptertest;

import android.support.v7.widget.RecyclerView;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

/**
 * Created by Steven.Xc.Tian on 16/11/28.
 */

public class CustomFastItemAdapter<Item extends IItem> extends FastItemAdapter<Item> {

    private MyAbstractWrapAdapter myAbstractWrapAdapter;

    public CustomFastItemAdapter(MyAbstractWrapAdapter adapter) {
        super();

        myAbstractWrapAdapter = adapter;
    }

    @Override
    public int getHolderAdapterPosition(RecyclerView.ViewHolder holder) {
        int pos = super.getHolderAdapterPosition(holder);
        return pos - myAbstractWrapAdapter.getItemInsertedBeforeCount(pos);
    }
}
