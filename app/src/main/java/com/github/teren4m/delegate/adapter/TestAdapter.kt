package com.github.teren4m.delegate.adapter

import android.content.Context
import android.util.Log
import com.github.teren4m.adapter.delegate.DelegateAdapter
import kotlinx.android.synthetic.main.item_test.*

class TestAdapter(context: Context) : DelegateAdapter<StringItem>(context) {

    override val layoutId = R.layout.item_test

    override fun onBind(position: Int, item: StringItem, viewHolder: KViewHolder) {
        Log.i("TestAdapter", item.str)
        viewHolder.view_text.text = item.str
    }

    override fun isForViewType(items: List<Any>, position: Int) =
        items[position] is StringItem

}