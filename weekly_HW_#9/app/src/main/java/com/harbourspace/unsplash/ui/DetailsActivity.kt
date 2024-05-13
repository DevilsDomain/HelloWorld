package com.harbourspace.unsplash.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.load
import com.harbourspace.unsplash.R
import com.harbourspace.unsplash.api.UnsplashApiProvider
import com.harbourspace.unsplash.model.cb.UnsplashPhotoResult
import com.harbourspace.unsplash.photoData.UnsplashPhotoDetails
import com.harbourspace.unsplash.utils.EXTRA_IMAGE
import com.harbourspace.unsplash.utils.EXTRA_PHOTO_ID

class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val photoId = intent.getStringExtra(EXTRA_PHOTO_ID)
        photoId?.let {
            viewModel.fetchPhotoDetails(it)
        }

        viewModel.photoDetails.observe(this, Observer { details ->
            details?.let {
                updateUI(it)
            }
        })
    }

    private fun updateUI(details: UnsplashPhotoDetails) {
        val city = details.location?.city
        val country = details.location?.country

        findViewById<TextView>(R.id.tv_photo_id).text = details.id
        findViewById<TextView>(R.id.cameraValue).text = details.exif?.model ?: "NA"
        findViewById<TextView>(R.id.focalLengthValue).text = details.exif?.focal_length ?: "NA"
        findViewById<TextView>(R.id.isoValue).text = details.exif?.iso.toString()
        findViewById<TextView>(R.id.apertureValue).text = details.exif?.aperture ?: "NA"
        findViewById<Button>(R.id.city).text = city ?: "NA"
        findViewById<Button>(R.id.country).text = country ?: "NA"
        findViewById<TextView>(R.id.username).text = details.user?.username ?: "NA"
        findViewById<TextView>(R.id.likesValue).text = details.likes.toString()
        findViewById<TextView>(R.id.downloadsValue).text = details.downloads.toString()
        findViewById<TextView>(R.id.location).text = "$city, $country"

        findViewById<ImageView>(R.id.iv_preview).load(details.urls?.regular) {
            crossfade(true)
            placeholder(R.drawable.ic_progress)
            error(R.drawable.ic_error)
        }
    }

    }
