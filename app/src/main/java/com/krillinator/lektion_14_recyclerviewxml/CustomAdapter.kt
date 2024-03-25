package com.krillinator.lektion_14_recyclerviewxml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(
    private var itemsList: List<String>
): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    var onItemClick: ((String) -> Unit)? = null

    internal inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.tv_itemName)

        // After - Primary Constructor
        init {
            view.setOnClickListener {
                onItemClick?.invoke(itemsList[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        val item = itemsList[position]

        holder.itemTextView.text = item
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }


}