package com.surajpal.a1_shorts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.surajpal.a1_shorts.adapter.VideoListAdapter
import com.surajpal.a1_shorts.databinding.ActivitySingleVideoPlayerActivtyBinding

class SingleVideoPlayerActivty : AppCompatActivity() {

    lateinit var binding: ActivitySingleVideoPlayerActivtyBinding
    lateinit var videoId: String
    lateinit var adapter: VideoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleVideoPlayerActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoId = intent.getStringExtra("videoId")!!
        setupViewPager()
    }

    private fun setupViewPager() {
       val options = FirestoreRecyclerOptions.Builder<VideoModel>()
           .setQuery(
               Firebase.firestore.collection("videos")
                   .whereEqualTo("videoId",videoId),
               VideoModel::class.java
           ).build()
        adapter = VideoListAdapter(options)
        binding.videoPager.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.stopListening()
    }
}