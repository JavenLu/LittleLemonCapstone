package com.example.littlelemoncapstone.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.*

class NetworkService(
    private val client: HttpClient = HttpClient()
) {

    private val url =
        "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"

    suspend fun fetchMenu(): List<MenuItemNetwork> {
        val text: String = client.get(url).body()

        val root = Json.parseToJsonElement(text).jsonObject
        val menuArray = root["menu"]!!.jsonArray

        return menuArray.map { element ->
            val obj = element.jsonObject
            MenuItemNetwork(
                id = obj["id"]!!.jsonPrimitive.int,
                title = obj["title"]!!.jsonPrimitive.content,
                description = obj["description"]!!.jsonPrimitive.content,
                price = obj["price"]!!.jsonPrimitive.content,
                image = obj["image"]!!.jsonPrimitive.content,
                category = obj["category"]!!.jsonPrimitive.content
            )
        }
    }
}