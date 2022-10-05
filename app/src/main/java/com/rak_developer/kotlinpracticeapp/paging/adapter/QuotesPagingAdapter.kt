package com.rak_developer.kotlinpracticeapp.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.Result

class QuotesPagingAdapter :
    PagingDataAdapter<Result, QuotesPagingAdapter.QuotesViewHolder>(DiffUtil()) {

    class QuotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtItem = view.findViewById<TextView>(R.id.txtItem)
        val txtName = view.findViewById<TextView>(R.id.txtName)

        fun bind(item: Result) {
            txtItem.text = item._id
            txtName.text = item.author
        }
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_programming_list_item, parent, false)
        return QuotesViewHolder(view)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }

    }
}