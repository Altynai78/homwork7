package com.example.youtubeparccer.repository

import androidx.lifecycle.LiveData
import com.example.youtubeparccer.core.resulst.Resource
import com.example.youtubeparccer.data.Playlists
import com.example.youtubeparccer.data.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.internal.NopCollector.emit


class Repository(private val remoteDataSource: RemoteDataSource) {
    fun getPlaylist(): LiveData<Resource<Playlists>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = remoteDataSource.getPlaylist()
        emit(response)
    }

    fun getPlaylistItems(playlistId: String): LiveData<Resource<Playlists>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val response = remoteDataSource.getPlaylistItems(playlistId)
        emit(response)
    }

    fun getVideo(videoId: String): LiveData<Resource<Playlists>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val response = remoteDataSource.getVideo(videoId)
        emit(response)
    }

}