package com.lifehealth.fitplanner.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Next(
    val href:String?,
    val title:String?,
)
