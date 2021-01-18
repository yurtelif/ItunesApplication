package com.yrtelf.itunesapplication.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.yrtelf.itunesapplication.model.AppDatabase
import com.yrtelf.itunesapplication.ui.SearchViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "localdb").build()
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(db.resultDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}