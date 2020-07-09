package com.yoloyoj.hse_homework1.filter_recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.yoloyoj.hse_homework1.R
import com.yoloyoj.hse_homework1.filter_recycler_adapter.holders.FilterItemHolder
import com.yoloyoj.hse_homework1.filter_recycler_adapter.models.FilterItem

class FilterRecycleAdapter(var items: List<FilterItem>) : RecyclerView.Adapter<FilterItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilterItemHolder(
            inflater.inflate(
                R.layout.filter_item,
                parent,
                false
            ) as CheckBox
        )
    }

    override fun onBindViewHolder(holder: FilterItemHolder, position: Int) {
        val filterItem = items[position]

        holder.apply {
            view.text = filterItem.text
            view.isChecked = filterItem.value

            view.setOnCheckedChangeListener { _, b ->
                items[position].value = b
            }
        }
    }

    override fun getItemCount(): Int =
        items.count()
}
