package com.github.teren4m.delegate.adapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list)
        val buttonAdd = findViewById<View>(R.id.button_add)

        val items = mutableListOf<UuidItem>()

        val adapter = CompositeDelegateAdapter.Builder()
            .add(TestAdapter())
            .build()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        buttonAdd.setOnClickListener {
            UUID.randomUUID().toString()
                .let(::UuidItem)
                .let(items::add)

            adapter.update(items)
        }
    }
}
