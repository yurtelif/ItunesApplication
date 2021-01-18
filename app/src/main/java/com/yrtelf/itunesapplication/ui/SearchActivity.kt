package com.yrtelf.itunesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.yrtelf.itunesapplication.R
import com.yrtelf.itunesapplication.databinding.ActivitySearchBinding
import com.yrtelf.itunesapplication.injection.ViewModelFactory

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(SearchViewModel::class.java)

        binding.viewModel = viewModel

    }
}