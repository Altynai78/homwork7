package com.example.youtubeparccer.data
interface ApiService {

    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<Playlists>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: Int = 50
    ): Response<Playlists>

    @GET("videos")
    suspend fun getVideo(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("id") videoId: String
    ): Response<Playlists>


}