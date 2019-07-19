package com.github.teren4m.adapter.delegate

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import kotlinx.android.extensions.LayoutContainer

abstract class BaseDelegateAdapter<T>(
    protected val context: Context
) {

    @get:LayoutRes
    protected abstract val layoutId: Int

    abstract fun getView(parent: ViewGroup): View

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

        inline fun <reified T> getTag(): T =
            containerView.tag.let {
                if (it is T) {
                    it
                } else {
                    error("Tag is ${it::class} but T is ${T::class}")
                }
            }

    }
}