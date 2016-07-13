package xyz.sahildave.trendy.itemlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import timber.log.Timber;
import xyz.sahildave.trendy.R;
import xyz.sahildave.trendy.data.model.Item;

/**
 * Created by sahil on 9/7/16.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private final List<Item> mValues;
    private ItemItemListener mItemItemListener;
    private int ITEM_LIST_CONTENT = R.layout.item_list_content;
    private int ITEM_LIST_LOAD = R.layout.item_list_content;

    public ItemListAdapter(List<Item> items, final ItemItemListener itemItemListener) {
        mValues = items;
        mItemItemListener = itemItemListener;
        setHasStableIds(true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new ViewHolder(view, mItemItemListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Item item = mValues.get(position);
        holder.mItem = item;
        if (item != null) {
        }
    }

    public void addItems(final List<Item> items) {
        if(items == null) {
            hideLoadMore();
            return;
        }

        int oldCount = mValues.size() + 1;
        mValues.addAll(items);
        int newCount = mValues.size();
        Timber.d("Adding - %s, %s", oldCount, newCount);
        notifyItemRangeInserted(oldCount, newCount);
    }

    public void showLoadMore() {
        mValues.add(null);
        Timber.d("ShowLoadMore");
        notifyItemInserted(mValues.size() + 1);
    }

    public void hideLoadMore() {
        if (getItemCount() > 0) {
            Item loadItem = mValues.get(mValues.size() - 1);
            if (loadItem == null) {
                Timber.d("hideLoadMore");
                mValues.remove(loadItem);
                notifyItemRemoved(mValues.size());
            }
        }
    }

    @Override
    public int getItemViewType(final int position) {
        return mValues.get(position) == null ? ITEM_LIST_LOAD : ITEM_LIST_CONTENT;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public long getItemId(final int position) {
//            Item item = mValues.get(position);
//            if (item != null) {
//                return item.getItemId();
//            }
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final ImageView mIdView;
        public final TextView mTitleView;
        public Item mItem;
        private final ItemItemListener mItemItemListener;

        public ViewHolder(View view, final ItemItemListener itemItemListener) {
            super(view);
            mView = view;
            mItemItemListener = itemItemListener;
            mIdView = (ImageView) view.findViewById(R.id.image);
            mTitleView = (TextView) view.findViewById(R.id.title);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            mItemItemListener.itemClicked(v, mItem);
        }
    }
}
interface ItemItemListener {
    void itemClicked(View v, Item clickedItem);
}
