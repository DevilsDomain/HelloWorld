package com.harbourspace.unsplash.photoData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exif(
    val aperture: String?,
    val exposure_time: String?,
    val focal_length: String?,
    val iso: Int?,
    val make: String?,
    val model: String?,
    val name: String?
): Parcelable