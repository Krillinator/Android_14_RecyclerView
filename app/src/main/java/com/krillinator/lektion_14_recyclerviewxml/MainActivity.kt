package com.krillinator.lektion_14_recyclerviewxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var customAdapter: CustomAdapter
    private val itemsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Boilerplate Setup - RECYCLER VIEW
        val recyclerView: RecyclerView = findViewById(R.id.rv_myRecyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)
        customAdapter = CustomAdapter(itemsList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter

        // PREPARE ITEMS
        for (i in 1..1000) {
            itemsList.add("Item $i")
        }

        customAdapter.notifyItemRangeInserted(1, 1000)

        // Listener
        customAdapter.onItemClick = {
            customAdapter.notifyItemRemoved(itemsList.indexOf(it))
            itemsList.remove(it)

            Toast.makeText(this, "You clicked $it", Toast.LENGTH_SHORT).show()
        }

    }
}