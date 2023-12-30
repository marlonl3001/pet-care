package data.repository

import Constants.ON_BOARDING_PREF_KEY
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import data.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent

class DataStoreOperationsImpl(
    private val dataStore: DataStore<Preferences>
): DataStoreOperations, KoinComponent {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_PREF_KEY)
    }

    override suspend fun saveOnboardingState(completed: Boolean) {
        dataStore.edit {preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun getOnboardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {
                it[PreferencesKey.onBoardingKey] ?: false
            }
    }
}