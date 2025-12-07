package com.example.littlelemoncapstone.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MenuItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MenuDatabase : RoomDatabase() {

    abstract fun menuItemDao(): MenuItemDao

    companion object {
        @Volatile
        private var INSTANCE: MenuDatabase? = null

        fun getInstance(context: Context): MenuDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MenuDatabase::class.java,
                    "little_lemon_db"
                ).fallbackToDestructiveMigration().build().also { INSTANCE = it }
            }
    }
}