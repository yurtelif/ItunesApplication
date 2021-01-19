package com.yrtelf.itunesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
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
        binding.rvResults.layoutManager = GridLayoutManager(this, 2)
        setUpTabLayout()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

    private fun setUpTabLayout() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.movies)))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.books)))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.apps)))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.music)))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewModel.setMediaType(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}