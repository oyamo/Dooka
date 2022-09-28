package com.oyamo.dooka_app.feature_wish_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.oyamo.dooka_app.feature_wish_list.data.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [WishlistEntity::class], version = 2)
abstract class WishlistDatabase : RoomDatabase() {
    abstract val wishlistDao: WishlistDao
}