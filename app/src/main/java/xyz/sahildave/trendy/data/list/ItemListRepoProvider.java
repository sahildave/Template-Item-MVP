package xyz.sahildave.trendy.data.list;

import android.support.annotation.NonNull;

import xyz.sahildave.trendy.data.api.ItemListService;

import static xyz.sahildave.trendy.util.Common.checkNotNull;

/**
 * Created by sahil on 6/3/16.
 */
public class ItemListRepoProvider {
    private ItemListRepoProvider() {
        // no instance
    }

    private static ItemListRepository repository = null;

    public synchronized static ItemListRepository getInMemoryRepoInstance(@NonNull ItemListService ItemsServiceApi) {
        checkNotNull(ItemsServiceApi);
        if (null == repository) {
            repository = new InMemoryItemListRepository(ItemsServiceApi);
        }
        return repository;
    }
}
