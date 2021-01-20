package com.yrtelf.itunesapplication.ui.detail

import androidx.lifecycle.MutableLiveData
import com.yrtelf.itunesapplication.base.BaseViewModel
import com.yrtelf.itunesapplication.model.ResultDao
import com.yrtelf.itunesapplication.model.Track

class TrackDetailViewModel(private val resultDao: ResultDao) : BaseViewModel() {

    val track: MutableLiveData<Track> = MutableLiveData()

}