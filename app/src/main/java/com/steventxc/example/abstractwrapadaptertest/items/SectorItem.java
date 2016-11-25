package com.steventxc.example.abstractwrapadaptertest.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.steventxc.example.abstractwrapadaptertest.R;

import java.util.List;

/**
 * Created by Steven on 16/11/25.
 */

public class SectorItem extends AbstractItem<SectorItem, SectorItem.ViewHolder> {
    public String letter;

    public SectorItem(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public void bindView(SectorItem.ViewHolder viewHolder, List<Object> payloads) {
        super.bindView(viewHolder, payloads);
        viewHolder.text.setText(letter);

        viewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "clicked " + letter, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void unbindView(SectorItem.ViewHolder holder) {
        super.unbindView(holder);
        holder.text.setText(null);
        holder.text.setOnClickListener(null);
    }

    @Override
    public int getType() {
        return R.id.item_type_sector;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.sector_item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
