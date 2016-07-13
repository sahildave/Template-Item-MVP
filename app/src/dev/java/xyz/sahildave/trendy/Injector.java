package xyz.sahildave.trendy;

import xyz.sahildave.trendy.data.api.ItemListServiceImpl;
import xyz.sahildave.trendy.data.list.ItemListRepoProvider;
import xyz.sahildave.trendy.data.list.ItemListRepository;

/**
 * Created by sahil on 9/7/16.
 */
public class Injector {
    public static ItemListRepository provideItemListRepository() {
        return ItemListRepoProvider.getInMemoryRepoInstance(new ItemListServiceImpl());
    }
}
