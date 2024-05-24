package com.alexkarav.testandroidvacc24.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    suspend fun saveUserInformation(username: String, password: String) {
        context.dataStore.edit { settings ->
            settings[usernameKey] = username
            settings[passwordKey] = password
        }
    }

    fun retrieveUsername(): Flow<String> {
        return context.dataStore.data.map {settings ->
            settings[usernameKey] ?: ""
        }
    }

    fun retrievePassword(): Flow<String> {
        return context.dataStore.data.map {settings ->
            settings[passwordKey] ?: ""
        }
    }

    suspend fun setAuthorizationToken(token: String) {
        context.dataStore.edit {settings ->
            settings[authorizationTokenKey] = token
        }
    }

    fun retrieveAuthorizationToken(): Flow<String> {
        return context.dataStore.data.map { settings ->
            settings[authorizationTokenKey] ?: ""
        }
    }

    companion object {
        val usernameKey = stringPreferencesKey("USERNAME")
        val passwordKey = stringPreferencesKey("PASSWORD")
        val authorizationTokenKey = stringPreferencesKey("AUTH_TOKEN")
    }
}