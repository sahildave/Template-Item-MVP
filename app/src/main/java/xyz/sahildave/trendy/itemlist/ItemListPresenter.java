package xyz.sahildave.trendy.itemlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import xyz.sahildave.trendy.data.list.ItemListRepository;
import xyz.sahildave.trendy.data.model.Item;

import static xyz.sahildave.trendy.util.Common.checkNotNull;


/**
 * Created by sahil on 9/7/16.
 */
public class ItemListPresenter implements ItemListContract.UserActionsListener{
    private final ItemListRepository mItemListRepository;
    private final ItemListContract.View mItemListView;


    private int currentPage = 1;
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;

    public ItemListPresenter(@NonNull ItemListRepository itemListRepository,
                             @NonNull ItemListContract.View itemListView) {
        mItemListRepository = checkNotNull(itemListRepository);
        mItemListView = checkNotNull(itemListView);
    }

    @Override
    public void setupItemRecycler(RecyclerView recyclerView) {
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    loading = true;
                    ++currentPage;
                    loadItems(false);
                }
            }
        });
    }

    @Override
    public void loadItems(boolean forceUpdate) {
        if (forceUpdate) {
            currentPage = 1;
            mItemListView.showEmpty();
        }

        mItemListRepository.getItems(mItemListView, currentPage, new ItemListRepository.LoadItemListCallback() {
            @Override
            public void onItemListLoading() {

            }

            @Override
            public void onItemListLoaded(List<Item> items, boolean success) {

            }
        });

    }
}
