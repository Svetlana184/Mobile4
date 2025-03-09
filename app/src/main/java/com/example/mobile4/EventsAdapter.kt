package com.example.mobile4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mobile4.databinding.ItemEventsBinding

class EventsAdapter: RecyclerView.Adapter<EventsAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemEventsBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var events: List<Country>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemEventsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val our_event = events[position]

            EventTitle.text = our_event.name
            textView2.text = our_event.web_pages[0]
            textView3.text = our_event.country
            textView4.text = our_event.alpha_two_code
        }
    }
}