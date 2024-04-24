package com.example.learngetapi.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.learngetapi.domain.manger.LocalUserManger
import com.example.learngetapi.utils.Constants
import com.example.learngetapi.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImpl(
    private val context:Context,

) : LocalUserManger {
    override suspend fun saveAppEntry() {
       context.dataStore.edit { settings ->
           settings[PrefrencesKeys.APP_ENTRY] = true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {prefrences ->
            prefrences[PrefrencesKeys.APP_ENTRY] ?: false
        }
    }
}

// name data store
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
private object PrefrencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
