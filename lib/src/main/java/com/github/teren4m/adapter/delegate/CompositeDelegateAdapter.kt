package com.github.teren4m.adapter.delegate

class CompositeDelegateAdapter(
    adapters: Array<BaseDelegateAdapter<*>>
) : BaseCompositeDelegateAdapter(adapters) {

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
