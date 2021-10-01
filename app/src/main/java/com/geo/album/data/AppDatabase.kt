package com.geo.album.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geo.album.BuildConfig
import com.geo.album.domain.models.AlbumResult
import com.geo.album.service.db.AlbumDao
import com.geo.album.service.db.Converters
import com.geo.album.utils.AppConstants
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory


/**
 * Created by George Thomas on 30/9/21
 */
@Database(version = 2, exportSchema = false, entities = [AlbumResult::class])
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val factory =
                    SupportFactory(SQLiteDatabase.getBytes(BuildConfig.DB_PASSPHRASE.toCharArray()))
                val instance = Room.databaseBuilder(
                    context, AppDatabase::class.java, AppConstants.DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .openHelperFactory(factory)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}