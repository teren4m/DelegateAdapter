package com.github.teren4m.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.teren4m.adapter.delegate.pages.PagesDiffCallback

class CompositeDelegateAdapter(
    private val adapters: Array<DelegateAdapter<*>>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Any>()

    override fun getItemViewType(position: Int): Int =
        adapters
            .indexOfFirst {
                it.isForViewType(data, position)
            }
            .apply {
                if (this == -1) {
                    error("Can not get viewType for position $position")
                }
            }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        adapters[viewType].let {
            val inflatedView = LayoutInflater.from(parent.context)
                .inflate(it.layoutId, parent, false)
            val holder = DelegateAdapter.KViewHolder(inflatedView)
            holder.setListener { position, item, _ ->
                it.onBindItem(position, item, holder)
            }
            holder
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItemViewType(position)
            .let {
                adapters[it]
            }
            .let {
                (holder as BaseViewHolder).bind(position, data[position])
            }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getItem(position: Int): Any {
        return data[position]
    }

    fun set(data: List<Any>) {
        this.data.clear()
        add(data)
    }

    fun add(data: List<Any>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        this.data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun update(newData: List<Any>) {
        val diffResult = DiffUtil.calculateDiff(PagesDiffCallback(newData, this.data))
        diffResult.dispatchUpdatesTo(this)
        this.data.clear()
        this.data.addAll(newData)
    }

    class Builder {

        private val adapters = mutableListOf<DelegateAdapter<*>>()

        fun add(delegateAdapter: DelegateAdapter<*>): Builder {
            adapters.add(delegateAdapter)
            return this
        }

        fun build(): CompositeDelegateAdapter {
            return CompositeDelegateAdapter(adapters.toTypedArray())
        }
    }
}
