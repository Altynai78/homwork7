package com.example.youtubeparccer.ui.details

import androidx.lifecycle.LiveData
import com.example.youtubeparccer.core.resulst.Resource
import com.example.youtubeparccer.core.ui.BaseViewModel
import com.example.youtubeparccer.data.Playlists
import com.example.youtubeparccer.repository.Repository

class DetailsViewModel(private val repository: Repository): BaseViewModel() {
    fun getPlaylistItems(playlistId: String): LiveData<Resource<Playlists>> {
        return repository.getPlaylistItems(playlistId)
    }
}