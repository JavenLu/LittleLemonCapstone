package com.example.littlelemoncapstone.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemoncapstone.data.MenuDatabase
import com.example.littlelemoncapstone.data.MenuItemEntity
import com.example.littlelemoncapstone.data.MenuRepository
import com.example.littlelemoncapstone.data.NetworkService

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val database = remember { MenuDatabase.getInstance(context) }
    val repository = remember { MenuRepository(database.menuItemDao(), NetworkService()) }

    var menuItems by remember { mutableStateOf<List<MenuItemEntity>>(emptyList()) }
    var searchPhrase by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        repository.refreshMenu()
        menuItems = repository.getMenu()
    }

    val filteredItems = menuItems
        .filter { selectedCategory == null || it.category.equals(selectedCategory, true) }
        .filter { searchPhrase.isBlank() || it.title.contains(searchPhrase, true) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            HeaderSection(navController = navController)
        }
        item {
            HeroSection(
                searchText = searchPhrase,
                onSearchTextChange = { searchPhrase = it }
            )
        }
        item {
            CategorySection(
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it },
                items = menuItems
            )
        }
        items(filteredItems) { item ->
            MenuListItem(item)
        }
    }
}