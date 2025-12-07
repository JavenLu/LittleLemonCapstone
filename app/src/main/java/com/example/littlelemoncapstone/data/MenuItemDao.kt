package com.example.littlelemoncapstone.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuItemDao {

    @Query("SELECT * FROM menu_items")
    fun getAllFlow(): Flow<List<MenuItemEntity>>

    @Query("SELECT * FROM menu_items")   // 这里的表名要和 @Entity(tableName = "menu_items") 一致
    suspend fun getAll(): List<MenuItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<MenuItemEntity>)

    @Query("DELETE FROM menu_items")
    suspend fun clearAll()
}