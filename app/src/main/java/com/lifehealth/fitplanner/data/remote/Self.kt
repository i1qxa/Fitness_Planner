package com.lifehealth.fitplanner.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Self(
    val title:String?,
    val href:String?,
)
