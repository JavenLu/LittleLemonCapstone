package com.example.littlelemoncapstone.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    private val firstNameKey = stringPreferencesKey("first_name")
    private val lastNameKey = stringPreferencesKey("last_name")
    private val emailKey = stringPreferencesKey("email")
    private val onboardingCompletedKey = booleanPreferencesKey("onboarding_completed")

    val firstName: Flow<String> =
        context.dataStore.data.map { it[firstNameKey] ?: "" }

    val lastName: Flow<String> =
        context.dataStore.data.map { it[lastNameKey] ?: "" }

    val email: Flow<String> =
        context.dataStore.data.map { it[emailKey] ?: "" }

    val onboardingCompleted: Flow<Boolean> =
        context.dataStore.data.map { it[onboardingCompletedKey] ?: false }

    suspend fun saveUser(first: String, last: String, email: String) {
        context.dataStore.edit { prefs ->
            prefs[firstNameKey] = first
            prefs[lastNameKey] = last
            prefs[emailKey] = email
            prefs[onboardingCompletedKey] = true
        }
    }

    suspend fun clear() {
        context.dataStore.edit { prefs ->
            prefs.clear()
        }
    }
}