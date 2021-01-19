package com.yrtelf.itunesapplication.ui

import androidx.lifecycle.MutableLiveData
import com.yrtelf.itunesapplication.base.BaseViewModel
import com.yrtelf.itunesapplication.model.Track

class SearchListViewModel: BaseViewModel() {
    val collectionName = MutableLiveData<String>()
    val collectionPrice = MutableLiveData<String>()
    val artworkUrl100 = MutableLiveData<String>()
    val releaseDate = MutableLiveData<String>()

    fun bind(track: Track ){
        collectionName.value = track.collectionName
        collectionPrice.value = track.collectionPrice
        artworkUrl100.value = track.artworkUrl100
        releaseDate.value = track.releaseDate
    }

    fun getDate():MutableLiveData<String>{
        return releaseDate
    }
}