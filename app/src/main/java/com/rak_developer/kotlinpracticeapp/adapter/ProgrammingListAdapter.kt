package com.rak_developer.kotlinpracticeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.model.ProgramingModel

class ProgrammingListAdapter :
    ListAdapter<ProgramingModel, ProgrammingListAdapter.ProgrammingViewHolder>(DiffUtil()) {

    class ProgrammingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtItem = view.findViewById<TextView>(R.id.txtItem)
        val txtName = view.findViewById<TextView>(R.id.txtName)

        fun bind(item: ProgramingModel) {
            txtItem.text = item.item
            txtName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_programming_list_item, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgramingModel>() {
        override fun areItemsTheSame(oldItem: ProgramingModel, newItem: ProgramingModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgramingModel,
            newItem: ProgramingModel
        ): Boolean {
            return oldItem == newItem
        }

    }
}