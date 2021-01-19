package com.yrtelf.itunesapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yrtelf.itunesapplication.R
import com.yrtelf.itunesapplication.databinding.SearchListItemBinding
import com.yrtelf.itunesapplication.model.Track

class SearchListAdapter: PagedListAdapter<Track, RecyclerView.ViewHolder>(SearchDiffUtilCallback())  {
    private lateinit var trackList:MutableList<Track>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListAdapter.ViewHolder {
        val binding: SearchListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.search_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(trackList[position])    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun updateArticleList(tracks: MutableList<Track>){
        if(tracks.isEmpty()){
            this.trackList = tracks
        } else{
            this.trackList.addAll(tracks)
        }

        notifyDataSetChanged()
    }

    fun clearList(){
        trackList.clear()
    }

    class ViewHolder(private val binding: SearchListItemBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = SearchListViewModel()

        fun bind(track: Track){
            viewModel.bind(track)
            binding.viewModel = viewModel
        }
    }

    class SearchDiffUtilCallback : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.trackId == newItem.trackId
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem == newItem
        }

    }



}