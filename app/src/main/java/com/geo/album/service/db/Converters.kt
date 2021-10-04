package com.geo.album.service.db

import androidx.room.TypeConverter
import com.geo.album.domain.models.AlbumResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken


/**
 * Created by George Thomas on 1/10/21
 */
class Converters {

    @TypeConverter
    fun albumListToJson(albumList: ArrayList<AlbumResult>): String? =
        Gson().toJson(albumList)

    @TypeConverter
    fun fromJsonToAlbumList(json: String): ArrayList<AlbumResult> {
        val gson = GsonBuilder().create()
        return gson.fromJson(json, object : TypeToken<ArrayList<AlbumResult>>() {}.type)
    }

    @TypeConverter
    fun stringArrayListToJson(arrayList: ArrayList<String>): String? =
        Gson().toJson(arrayList)

    @TypeConverter
    fun fromJsonToStringArrayList(json: String): ArrayList<String> {
        val gson = GsonBuilder().create()
        return gson.fromJson(json, object : TypeToken<ArrayList<String>>() {}.type)
    }
}