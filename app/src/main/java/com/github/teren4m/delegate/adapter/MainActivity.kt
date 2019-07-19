package com.github.teren4m.delegate.adapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list)
        val buttonAdd = findViewById<View>(R.id.button_add)

        val items = mutableListOf<StringItem>()
        var counter = 0

        val adapter = CompositeDelegateAdapter.Builder()
            .add(TestAdapter(this))
            .build()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        buttonAdd.setOnClickListener {

            counter.toString()
                .let(::StringItem)
                .let(items::add)

            adapter.update(items)

            counter++
        }
    }
}
