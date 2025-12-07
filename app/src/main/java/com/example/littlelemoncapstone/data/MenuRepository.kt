package com.example.littlelemoncapstone.data

import kotlinx.coroutines.flow.Flow

class MenuRepository(
    private val dao: MenuItemDao,
    private val networkService: NetworkService
) {

    val menuList: Flow<List<MenuItemEntity>> = dao.getAllFlow()

    suspend fun refreshMenu() {
        val networkItems = networkService.fetchMenu()
        val entities = networkItems.map {
            MenuItemEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                image = it.image,
                category = it.category
            )
        }
        dao.clearAll()
        dao.insertAll(entities)
    }

    // 关键：这个就是 HomeScreen 里要调用的函数
    suspend fun getMenu(): List<MenuItemEntity> = dao.getAll()
}