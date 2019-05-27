package com.github.teren4m.delegate.adapter

import com.github.teren4m.adapter.delegate.pages.Id

data class StringItem(
    val str: String
) : Id {

    override fun getId(): String = str

    override fun toString(): String {
        return str
    }

}