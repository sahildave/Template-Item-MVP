package xyz.sahildave.trendy;

import xyz.sahildave.cleartax.data.list.ItemListRepoProvider;
import xyz.sahildave.cleartax.data.list.ItemListRepository;

/**
 * Created by sahil on 9/7/16.
 */
public class Injector {
    public static ItemListRepository provideItemListRepository() {
        return ItemListRepoProvider.getInMemoryRepoInstance(new FakeItemListServiceApiImpl());
    }
}
