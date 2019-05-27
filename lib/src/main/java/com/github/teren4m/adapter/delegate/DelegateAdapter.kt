package com.github.teren4m.adapter.delegate

import android.view.View
import androidx.annotation.LayoutRes
import kotlinx.android.extensions.LayoutContainer

abstract class DelegateAdapter<T> {

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun onBind(position: Int, item: T, viewHolder: KViewHolder)

    fun onBindItem(position: Int, item: Any, viewHolder: KViewHolder) {
        onBind(position, item as T, viewHolder)
    }

    abstract fun isForViewType(items: List<Any>, position: Int): Boolean

    fun createViewHolder(parent: View): KViewHolder =
        KViewHolder(parent)

    class KViewHolder(
        view: View
    ) : BaseViewHolder(view), LayoutContainer {

        override val containerView = view

    }
}