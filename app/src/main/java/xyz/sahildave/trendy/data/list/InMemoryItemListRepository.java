package xyz.sahildave.trendy.data.list;

import android.support.annotation.NonNull;

import xyz.sahildave.trendy.data.api.ItemListService;
import xyz.sahildave.trendy.itemlist.ItemListContract;

import static xyz.sahildave.trendy.util.Common.checkNotNull;


/**
 * Created by sahil on 6/3/16.
 */
class InMemoryItemListRepository implements ItemListRepository {

    private final ItemListService mItemListServiceApi;
    private boolean mGetAllItemsCalled;

    public InMemoryItemListRepository(@NonNull ItemListService ItemListServiceApi) {
        mItemListServiceApi = checkNotNull(ItemListServiceApi);
        mItemListServiceApi.init();
    }

    @Override
    public void getItems(ItemListContract.View contextView, int page, @NonNull LoadItemListCallback callback) {

    }
}
