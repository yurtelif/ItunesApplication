package com.yrtelf.itunesapplication.ui

import android.util.Log
import com.yrtelf.itunesapplication.base.BaseViewModel
import com.yrtelf.itunesapplication.model.Result
import com.yrtelf.itunesapplication.model.ResultDao
import com.yrtelf.itunesapplication.network.ItunesApi
import com.yrtelf.itunesapplication.network.ItunesRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel(private val resultDao: ResultDao): BaseViewModel(){

    @Inject
    lateinit var itunesApi: ItunesApi

    var disposable: CompositeDisposable = CompositeDisposable()


    init {
        loadArticles("john")
    }

    private fun loadArticles(term: String){
        var resultList: List<Result> = emptyList()
        disposable.add(
            itunesApi.searchTracks("jack+johnson")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                // subscribe instead of subscribeWith
                .subscribe({ response ->
                    Log.d("resssponse1", "searchResult: " + response.body()?.resultCount)
                    Log.d("resssponse2", "searchResult: " + response.body()?.results?.get(0)?.collectionName)
                }))

    }

}