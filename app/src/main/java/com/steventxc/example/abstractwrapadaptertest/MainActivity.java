package com.steventxc.example.abstractwrapadaptertest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.steventxc.example.abstractwrapadaptertest.items.SectorItem;
import com.steventxc.example.abstractwrapadaptertest.items.TextItem;

public class MainActivity extends AppCompatActivity {

    private FastItemAdapter<TextItem> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyAbstractWrapAdapter<SectorItem> wrapAdapter = new MyAbstractWrapAdapter<>();


        mAdapter = new FastItemAdapter<>();
        mAdapter.withOnClickListener(new FastAdapter.OnClickListener<TextItem>() {
            @Override
            public boolean onClick(View v, IAdapter<TextItem> adapter, TextItem item, int position) {
                String msg = "clicked item " + item.getLetter();
                getSupportActionBar().setTitle(msg);
                return true;
            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position + 1) % MyAbstractWrapAdapter.SPAN == 0)
                    return 3;

                return 1;
            }
        });

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(manager);
//        rv.setAdapter(mAdapter);
        rv.setAdapter(wrapAdapter.wrap(mAdapter));

        for (int i = 1; i < 101; i++) {
            TextItem item = new TextItem(i + "");
            mAdapter.add(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
