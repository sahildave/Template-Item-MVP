package xyz.sahildave.trendy.data.list;

import android.support.annotation.NonNull;

import java.util.List;

import xyz.sahildave.trendy.data.model.Item;
import xyz.sahildave.trendy.itemlist.ItemListContract;

/**
 * Created by sahil on 9/7/16.
 */
public interface ItemListRepository {
    interface LoadItemListCallback {
        void onItemListLoading();

        void onItemListLoaded(List<Item> items, boolean success);
    }

    interface GetItemCallback {
        void onItemLoaded(Item Item, boolean success);
    }

    void getItems(ItemListContract.View contextView, int page, @NonNull LoadItemListCallback callback);
}
