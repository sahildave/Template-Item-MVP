package xyz.sahildave.trendy.data.api;

import java.util.List;

import xyz.sahildave.trendy.data.model.Item;
import xyz.sahildave.trendy.itemlist.ItemListContract;


/**
 * Created by sahil on 6/3/16.
 */
public interface ItemListService {
    interface ItemListServiceCallbacks<T> {
        void onLoaded(T items);
    }

    void init();

    void destroy();

    void getAllItems(ItemListContract.View contextView, int page,
                     ItemListServiceCallbacks<List<Item>> callback);
}
