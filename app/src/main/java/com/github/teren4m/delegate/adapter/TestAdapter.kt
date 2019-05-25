package com.github.teren4m.delegate.adapter

import android.view.View
import android.widget.TextView
import com.github.teren4m.adapter.delegate.DelegateAdapter

class TestAdapter : DelegateAdapter<UuidItem>() {

    override val layoutId = R.layout.item_test

    private lateinit var viewText: TextView

    override fun onCreated(view: View) {
        viewText = view.findViewById(R.id.text)
    }

    override fun onBind(position: Int, item: UuidItem, viewHolder: KViewHolder) {
        viewText.text = item.uuid
    }

    override fun isForViewType(items: List<Any>, position: Int) = items[position] is UuidItem
}