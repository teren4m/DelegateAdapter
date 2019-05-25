package com.github.teren4m.delegate.adapter

import com.github.teren4m.adapter.delegate.pages.Id

data class UuidItem(
    val uuid: String
) : Id {

    override fun getId(): String = uuid

}