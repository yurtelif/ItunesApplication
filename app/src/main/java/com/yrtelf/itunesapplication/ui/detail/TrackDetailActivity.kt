package com.yrtelf.itunesapplication.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.yrtelf.itunesapplication.R
import com.yrtelf.itunesapplication.databinding.ActivityTrackDetailBinding
import com.yrtelf.itunesapplication.injection.ViewModelFactory
import com.yrtelf.itunesapplication.model.Track
import com.yrtelf.itunesapplication.util.TRACK

class TrackDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackDetailBinding
    private lateinit var viewModel: TrackDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val track = intent.getSerializableExtra(TRACK) as? Track
        binding = DataBindingUtil.setContentView(this, R.layout.activity_track_detail)
        viewModel = ViewModelProviders.of(this,ViewModelFactory(this)).get(TrackDetailViewModel::class.java)
        viewModel.track.value = track
        binding.viewModel = viewModel
    }
}