package com.example.youtubeparccer.data

import com.example.youtubeparccer.core.network.BaseDataSource
import com.example.youtubeparccer.core.utlis.channelId
import com.example.youtubeparccer.core.utlis.part

class RemoteDataSource(private val apiService: ApiService): BaseDataSource() {
    suspend fun getPlaylist() = getResult {
        apiService.getPlaylist(
            part,
            channelId,
            API_KEY
        )
    }

    suspend fun getPlaylistItems(playlistId: String) = getResult {
        apiService.getPlaylistItems(
            part,
            API_KEY,
            playlistId
        )
    }

    suspend fun getVideo(videoId: String) = getResult {
        apiService.getVideo(
            part,
            API_KEY,
            videoId
        )
    }
}