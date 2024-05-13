package com.harbourspace.unsplash.photoData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Location(
    val city: String?,
    val country: String?,
    val position: Position?
): Parcelable