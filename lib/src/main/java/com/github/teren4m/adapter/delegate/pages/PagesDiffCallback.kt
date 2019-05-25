package com.github.teren4m.adapter.delegate.pages

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil

class PagesDiffCallback(
    private var newPersons: List<Any>,
    private var oldPersons: List<Any>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldPersons.size
    }

    override fun getNewListSize(): Int {
        return newPersons.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldPersons[oldItemPosition]
        val newItem = newPersons[newItemPosition]
        return if (oldItem is Id && newItem is Id) {
            oldItem.getId() == newItem.getId()
        } else {
            oldItem == newItem
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition] == newPersons[newItemPosition]
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}