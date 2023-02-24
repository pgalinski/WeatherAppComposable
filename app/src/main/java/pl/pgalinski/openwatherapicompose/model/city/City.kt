package pl.pgalinski.openwatherapicompose.model.city

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val name: String,
    val lat: Float,
    val long: Float
) : Parcelable