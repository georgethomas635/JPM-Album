package com.geo.album.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by George Thomas on 29/9/21
 */

/**
┌────────────────────────┬───────────────────────┐
│                        │                       │
│                        │                       │
│          id            │         title         │
│                        │                       │
│                        │                       │
├────────────────────────┼───────────────────────┤
│                        │                       │
│                        │                       │
│                        │                       │
│           <Int>        │        <String>       │
│                        │                       │
│                        │                       │
│                        │                       │
│                        │                       │
│                        │                       │
│                        │                       │
└────────────────────────┴───────────────────────┘
 */
@Entity(tableName = "album")
data class AlbumResult(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String
)
