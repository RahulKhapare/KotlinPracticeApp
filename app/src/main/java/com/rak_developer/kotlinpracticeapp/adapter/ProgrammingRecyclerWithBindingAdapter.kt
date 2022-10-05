package com.rak_developer.kotlinpracticeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rak_developer.kotlinpracticeapp.databinding.ActivityProgrammingListItemBinding
import com.rak_developer.kotlinpracticeapp.model.ProgramingModel

class ProgrammingRecyclerWithBindingAdapter(private val programmingList: List<ProgramingModel>) :
    RecyclerView.Adapter<ProgrammingRecyclerWithBindingAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ActivityProgrammingListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingRecyclerWithBindingAdapter.ViewHolder {
        val binding = ActivityProgrammingListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)

    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(programmingList[position]) {
                binding.txtItem.text = this.item
                binding.txtName.text = this.name
            }
        }
    }

    override fun getItemCount(): Int {
        return programmingList.size
    }


}