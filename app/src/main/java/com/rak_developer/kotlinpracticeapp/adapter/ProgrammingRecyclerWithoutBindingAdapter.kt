package com.rak_developer.kotlinpracticeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.model.ProgramingModel

class ProgrammingRecyclerWithoutBindingAdapter(private val programmingList: List<ProgramingModel>) :
    RecyclerView.Adapter<ProgrammingRecyclerWithoutBindingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingRecyclerWithoutBindingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_programming_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: ProgrammingRecyclerWithoutBindingAdapter.ViewHolder,
        position: Int
    ) {
        val model = programmingList[position]
        holder.txtItem.text = model.item
        holder.txtName.text = model.name
    }

    override fun getItemCount(): Int {
        return programmingList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txtItem = itemView.findViewById<TextView>(R.id.txtItem)
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
    }
}