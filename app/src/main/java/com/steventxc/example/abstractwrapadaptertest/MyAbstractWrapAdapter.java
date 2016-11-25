package com.steventxc.example.abstractwrapadaptertest;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.AbstractWrapAdapter;
import com.steventxc.example.abstractwrapadaptertest.items.SectorItem;
import com.steventxc.example.abstractwrapadaptertest.items.TextItem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Steven on 16/11/25.
 */

public class MyAbstractWrapAdapter<Item extends IItem> extends AbstractWrapAdapter<Item> {
    public static final int SPAN = 10;

    private ArrayList<Item> mList = new ArrayList<>();

    public MyAbstractWrapAdapter() {
        super(Collections.EMPTY_LIST);

        setItems(mList);
    }

    @Override
    public boolean shouldInsertItemAtPosition(int position) {
        // every 10 rows
        int flag = (position + 1) % (SPAN);

        if (flag == 0) {
            // I want to add item dynamically here, so it will increase with data in the main adapter
            SectorItem item = new SectorItem("Sector " + mList.size());
            mList.add((Item) item);
            return true;
        }

        return false;
    }

    @Override
    public int itemInsertedBeforeCount(int position) {
        // TODO: 16/11/25  I'm not sure this is the best way

        for (int i = 0; ; i++) {
            int span = SPAN * (i + 1) + i;
            if (position < span) {
                return i;
            }
        }

    }


}
