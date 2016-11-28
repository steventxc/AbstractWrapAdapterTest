package com.steventxc.example.abstractwrapadaptertest;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.AbstractWrapAdapter;
import com.steventxc.example.abstractwrapadaptertest.items.SectorItem;

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

        for (int i = 0; i < 12; i++) {
            SectorItem item = new SectorItem("Sector " + i).withIdentifier(i);
            mList.add((Item) item);
        }

        setItems(mList);
    }

    @Override
    public boolean shouldInsertItemAtPosition(int position) {
        // every 10 rows
        int flag = (position + 1) % (SPAN);

        if (flag == 0) {
            // I want to add item dynamically here, so it will increase with data in the main adapter

            boolean bingo = false;
            for (IItem item : mList) {
                if (item.getIdentifier() == position) {
                    bingo = true;
                    break;
                }
            }

            if (!bingo) {
                SectorItem item = new SectorItem("Sector " + mList.size()).withIdentifier(position);
                mList.add((Item) item);
            }

            return true;
        }

        return false;
    }

    @Override
    public int itemInsertedBeforeCount(int position) {
        return getItemInsertedBeforeCount(position);
    }

    public int getItemInsertedBeforeCount(int position) {
        return position / SPAN;
    }

    @Override
    public int getItemCount() {
        int itemCount = getAdapter().getItemCount();

        int temp = itemCount / (SPAN - 1);
        if (itemCount % (SPAN - 1) == 0)
            temp --;

        return itemCount + temp;
    }
}
