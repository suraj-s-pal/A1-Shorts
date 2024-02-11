package com.surajpal.a1_shorts.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.surajpal.a1_shorts.SingleVideoPlayerActivty
import com.surajpal.a1_shorts.VideoModel
import com.surajpal.a1_shorts.databinding.ProfileVideoItemRowBinding

class ProfileVideoAdapter(options: FirestoreRecyclerOptions<VideoModel>) :
    FirestoreRecyclerAdapter<VideoModel, ProfileVideoAdapter.VideoViewHolder>(options) {

    inner class VideoViewHolder(private val binding: ProfileVideoItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(video: VideoModel) {
            Glide.with(binding.thumbnailImageView)
                .load(video.url)
                .into(binding.thumbnailImageView)
            binding.thumbnailImageView.setOnClickListener{
                val intent = Intent(binding.thumbnailImageView.context,SingleVideoPlayerActivty::class.java)
                intent.putExtra("videoId",video.videoId)
                binding.thumbnailImageView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
       val binding = ProfileVideoItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int, model: VideoModel) {
       holder.bind(model)
    }
}