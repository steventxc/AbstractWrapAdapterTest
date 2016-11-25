package com.steventxc.example.abstractwrapadaptertest.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.steventxc.example.abstractwrapadaptertest.R;

import java.util.List;

/**
 * Created by Steven on 16/11/25.
 */

public class TextItem extends AbstractItem<TextItem, TextItem.ViewHolder> {

    public String letter;

    public TextItem(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        super.bindView(viewHolder, payloads);
        viewHolder.text.setText(letter);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.text.setText(null);
    }

    @Override
    public int getType() {
        return R.id.item_type_text;
    }

    @Override
    public int getLayoutRes() {
        return android.R.layout.simple_list_item_1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
