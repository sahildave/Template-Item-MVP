package xyz.sahildave.trendy.itemlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import xyz.sahildave.trendy.data.model.Item;

/**
 * Created by sahil on 9/7/16.
 */
public interface ItemListContract {
    interface View {
        void setProgressIndicator(boolean active);

        void setItems(List<Item> items);

        void showError();

        void showEmpty();

        void showLoadMore();

        Context getViewContext();
    }

    interface UserActionsListener {
        void setupItemRecycler(RecyclerView recyclerView);

        void loadItems(boolean forceUpdate);
    }
}