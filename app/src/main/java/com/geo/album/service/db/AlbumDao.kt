package com.geo.album.service.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geo.album.domain.models.AlbumResult

/**
 * Created by George Thomas on 30/9/21
 */
@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbums(albumResponse: List<AlbumResult>)

    @Query("Select * from album ORDER BY title")
    fun getAlbums(): List<AlbumResult>
}