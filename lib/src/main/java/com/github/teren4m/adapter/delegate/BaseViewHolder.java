package com.github.teren4m.adapter.delegate;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private ItemInflateListener listener;

    public BaseViewHolder(View parent) {
        super(parent);
    }

    public final void setListener(ItemInflateListener listener) {
        this.listener = listener;
    }

    public final void bind(int position, Object item) {
        listener.inflated(position, item, itemView);
    }

    interface ItemInflateListener {
        void inflated(int position, Object viewType, View view);
    }
}

