package com.yrtelf.itunesapplication.ui.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yrtelf.itunesapplication.R
import com.yrtelf.itunesapplication.databinding.SearchListItemBinding
import com.yrtelf.itunesapplication.model.Track
import com.yrtelf.itunesapplication.ui.detail.TrackDetailActivity
import com.yrtelf.itunesapplication.util.TRACK

class SearchListAdapter() :
    PagedListAdapter<Track, RecyclerView.ViewHolder>(SearchDiffUtilCallback()) {
    private lateinit var trackList: MutableList<Track>
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: SearchListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.search_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(context, trackList[position])
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun updateArticleList(tracks: MutableList<Track>) {
        if (tracks.isEmpty()) {
            this.trackList = tracks
        } else {
            this.trackList.addAll(tracks)
        }

        notifyDataSetChanged()
    }

    fun clearList() {
        trackList.clear()
    }

    class ViewHolder(private val binding: SearchListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = SearchListViewModel()

        fun bind(context: Context, track: Track) {
            viewModel.bind(track)
            binding.viewModel = viewModel
            binding.cardTrack.setOnClickListener {
                val intent = Intent(context, TrackDetailActivity::class.java)
                intent.putExtra(TRACK, track)
                context.startActivity(intent)
            }
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