package com.example.youtubeparccer.ui.player

import androidx.lifecycle.LiveData
import com.example.youtubeparccer.core.resulst.Resource
import com.example.youtubeparccer.core.ui.BaseViewModel
import com.example.youtubeparccer.data.Playlists
import com.example.youtubeparccer.repository.Repository

class PlayerViewModel(private val repository: Repository): BaseViewModel() {
    fun getVideo(videoId: String): LiveData<Resource<Playlists>> {
        return repository.getVideo(videoId)
    }
}