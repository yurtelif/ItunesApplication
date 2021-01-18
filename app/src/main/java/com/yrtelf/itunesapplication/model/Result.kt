package com.yrtelf.itunesapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result") class Result (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "collection_name") val collectionName:String?,
    @ColumnInfo(name = "collection_view_url") val collectionPrice:String?,
    @ColumnInfo(name = "collection_view") val artworkUrl100:String?,
    @ColumnInfo(name = "releaseDate") val releaseDate:String?
)

data class Track(val collectionName:String?,
                 val collectionPrice:String?,
                 val artworkUrl100:String?,
                 val releaseDate:String?
)

