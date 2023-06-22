package com.example.youtubeparccer.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeparccer.core.resulst.Resource
import com.example.youtubeparccer.core.ui.BaseViewModel
import com.example.youtubeparccer.data.Playlists
import com.example.youtubeparccer.repository.Repository

class PlaylistViewModel(private val repository: Repository): BaseViewModel(){
    fun getPlaylist(): LiveData<Resource<Playlists>> {
        return repository.getPlaylist()
    }
}