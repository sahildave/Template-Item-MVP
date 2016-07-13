package xyz.sahildave.trendy.itemlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xyz.sahildave.trendy.Injector;
import xyz.sahildave.trendy.R;
import xyz.sahildave.trendy.data.model.Item;


public class ItemListActivity extends AppCompatActivity implements ItemListContract.View, ItemItemListener {

    private ItemListPresenter mItemListPresenter;
    private RecyclerView mRecyclerView;
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_list);
        mAdapter = new ItemListAdapter(new ArrayList<Item>(), this);
        mRecyclerView.setAdapter(mAdapter);

        mItemListPresenter = new ItemListPresenter(Injector.provideItemListRepository(), this);
        mItemListPresenter.setupItemRecycler(mRecyclerView);
        mItemListPresenter.loadItems(true);
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void setItems(List<Item> items) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoadMore() {

    }

    @Override
    public Context getViewContext() {
        return null;
    }

    @Override
    public void itemClicked(View v, Item clickedItem) {

    }
}
