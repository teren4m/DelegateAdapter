package com.github.teren4m.adapter.delegate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class DelegateAdapter<T>(
    context: Context
) : BaseDelegateAdapter<T>(context) {

    override fun getView(parent: ViewGroup): View =
        LayoutInflater.from(context).inflate(layoutId, parent, false)

}