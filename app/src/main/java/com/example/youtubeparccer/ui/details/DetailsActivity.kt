package com.example.youtubeparccer.ui.details

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import com.example.youtubeparccer.core.resulst.Resource
import com.example.youtubeparccer.core.ui.BaseActivity
import com.example.youtubeparccer.core.utlis.ConnectionLiveData
import com.example.youtubeparccer.ui.details.adapter.DetailsAdapter
import com.example.youtubeparccer.ui.player.PlayerActivity
import com.example.youtubeparccer.ui.playlist.PlaylistActivity.Companion.KEY_FOR_COUNT
import com.example.youtubeparccer.ui.playlist.PlaylistActivity.Companion.KEY_FOR_DESC
import com.example.youtubeparccer.ui.playlist.PlaylistActivity.Companion.KEY_FOR_ID
import com.example.youtubeparccer.ui.playlist.PlaylistActivity.Companion.KEY_FOR_TITLE

class DetailsActivity : BaseActivity<ActivityDetailsBinding, DetailsViewModel>() {
    override val viewModel: DetailsViewModel by viewModel()
    private lateinit var adapter: DetailsAdapter

    override fun inflateViewBinding(): ActivityDetailsBinding {
        return ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun setupLiveData() {
        super.setupLiveData()
        val playlistId = intent.getStringExtra(KEY_FOR_ID)
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.getPlaylistItems(playlistId.toString()).observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    adapter.addList(it.data?.items as ArrayList<ClipData.Item>)
                    binding.rvVideos.adapter = adapter
                    viewModel.loading.postValue(false)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    viewModel.loading.postValue(false)
                }
                Resource.Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
            }
        }
    }

    override fun checkInternet() {
        super.checkInternet()
        ConnectionLiveData(application).observe(this) {
            if (it){
                binding.clNoInternet.isVisible = false
                binding.clMain.isVisible = true
            } else {
                binding.clNoInternet.isVisible = true
                binding.clMain.isVisible = false
            }
        }
    }

    override fun initClickListener() {
        super.initClickListener()
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun setUI() {
        super.setUI()
        setDataFIntent()
        adapter = DetailsAdapter(this::onClick)
        binding.rvVideos.adapter = adapter
        binding.tvCountVideos.text = intent.getStringExtra(KEY_FOR_COUNT) + " video series"
    }

    private fun onClick(item: ClipData.Item) {
        val intent = Intent(this, PlayerActivity::class.java)
        intent.putExtra(KEY_FOR_VIDEOID, item.contentDetails.videoId)
        startActivity(intent)
    }

    private fun setDataFIntent() {
        val title = intent.getStringExtra(KEY_FOR_TITLE)
        val desc = intent.getStringExtra(KEY_FOR_DESC)
        binding.tvPlaylistTitle.text = title
        binding.tvDescription.text = desc
    }

    companion object {
        const val KEY_FOR_VIDEOID = "Dawdaw"
    }

}