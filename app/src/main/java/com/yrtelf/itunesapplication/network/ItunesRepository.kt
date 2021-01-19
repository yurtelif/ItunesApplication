package com.yrtelf.itunesapplication.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yrtelf.itunesapplication.model.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ItunesRepository {

    /**
     *  @Inject
    lateinit var itunesApi: ItunesApi

    private lateinit var disposable: CompositeDisposable

    fun searchResult(term: String): List<Result>{

    var resultList: List<Result> = emptyList()
    disposable.add(
    itunesApi.searchTracks(term)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribeOn(Schedulers.io())
    // subscribe instead of subscribeWith
    .subscribe({ response ->
    Log.d("resssponse", "searchResult: " + response.body().toString())
    resultList = response.body()?.resultList!!
    }))
    return resultList
    }
     */




}

