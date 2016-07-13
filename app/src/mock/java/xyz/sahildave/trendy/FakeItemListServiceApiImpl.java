package xyz.sahildave.trendy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


/**
 * Created by sahil on 6/3/16.
 */
public class FakeItemListServiceApiImpl implements ItemListService {

    @Override
    public void init() {
        AssetProvider.init();
    }

    @Override
    public void destroy() {
        AssetProvider.nullify();
    }

    @Override
    public void getAllItems(ItemListContract.View contextView, int page, final ItemListServiceCallbacks<List<Item>> callback) {
        checkNotNull(contextView);

        String json = AssetProvider.getInstance().readFromAssets(contextView.getViewContext(), "recent_news.json");
        List<Item> Items = new Gson().fromJson(json, new TypeToken<List<Item>>() {
        }.getType());
        callback.onLoaded(Items);
    }
}
