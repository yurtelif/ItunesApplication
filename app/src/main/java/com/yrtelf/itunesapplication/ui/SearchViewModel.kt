package com.yrtelf.itunesapplication.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.yrtelf.itunesapplication.base.BaseViewModel
import com.yrtelf.itunesapplication.model.Result
import com.yrtelf.itunesapplication.model.ResultDao
import com.yrtelf.itunesapplication.model.Track
import com.yrtelf.itunesapplication.network.ItunesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel(private val resultDao: ResultDao) : BaseViewModel() {

    @Inject
    lateinit var itunesApi: ItunesApi
    var searchWord: MutableLiveData<String> = MutableLiveData()
    var mediaType: MutableLiveData<String> = MutableLiveData()
    var buttonVisibility: MutableLiveData<Boolean> = MutableLiveData()
    var disposable: CompositeDisposable = CompositeDisposable()
    val searchListAdapter = SearchListAdapter()
    val limit = 25
    var offset = 0

    init {
        mediaType.value = "movie"
        buttonVisibility.value = false
        searchListAdapter.updateArticleList(arrayListOf())
    }

    fun search() {
        disposable.add(
            itunesApi.searchTracks(searchWord.value, media = mediaType.value, offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    buttonVisibility.value = true
                    searchListAdapter.updateArticleList(response.results)
                    offset += 25
                })
        )

    }

    fun setMediaType(currentTab: Int) {
        when (currentTab) {
            0 -> mediaType.value = "movie"
            1 -> mediaType.value = "ebook"
            2 -> mediaType.value = "software"
            3 -> mediaType.value = "music"
        }
        searchListAdapter.clearList()
        search()
    }

}