package com.surajpal.a1_shorts

import com.google.firebase.Timestamp

data class VideoModel(
    var videoId : String = "",
    var title : String = "",
    var url : String = "",
    var uploaderId : String = "",
    var createdTime : Timestamp = Timestamp.now()
)