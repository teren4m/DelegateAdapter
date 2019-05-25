package com.github.teren4m.adapter.delegate

import android.view.View
import androidx.annotation.LayoutRes

abstract class DelegateAdapter<T> {

    @get:LayoutRes
    abstract val layoutId: Int

    open fun onCreated(view: View) = Unit

    abstract fun onBind(position: Int, item: T, viewHolder: KViewHolder)

    fun onBindItem(position: Int, item: Any, viewHolder: KViewHolder) {
        onBind(position, item as T, viewHolder)
    }

    abstract fun isForViewType(items: List<Any>, position: Int): Boolean

    fun createViewHolder(parent: View): KViewHolder =
        KViewHolder(parent, ::onCreated)

    class KViewHolder(val containerView: View, onCreated: (View) -> Unit) : BaseViewHolder(containerView) {

        init {
            onCreated(containerView)
        }

        fun layout(block: View.() -> Unit) {
            containerView.block()
        }
    }
}