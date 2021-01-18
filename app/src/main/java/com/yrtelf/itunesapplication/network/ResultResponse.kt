package com.yrtelf.itunesapplication.network

import com.google.gson.annotations.SerializedName
import com.yrtelf.itunesapplication.model.Result
import com.yrtelf.itunesapplication.model.Track

data class ResultResponse (
    @SerializedName("resultCount") var resultCount: String,
    @SerializedName("results") var results: List<Result>
)