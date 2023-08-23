package com.juan.equipoec4.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Entity(tableName = "equipo")
@Parcelize
data class Equipo(
    @PrimaryKey
    val id: Int,
    val gender: String,
    val name : String,
    @SerializedName("short_code")
    val short_code:  String,
    @SerializedName("image_path")
    val image_path: String,
    val founded: String,
    val type:String,
    val placeholder: String,
    @SerializedName("last_played_at")
    val last_played_at :String
) : Parcelable
fun getData(): List<Equipo> =
    listOf(
        Equipo(1,"asd","juan","123","31","231","123","213","213")
    )
