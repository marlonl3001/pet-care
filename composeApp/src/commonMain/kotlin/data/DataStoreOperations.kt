package data

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnboardingState(completed: Boolean)
    fun getOnboardingState(): Flow<Boolean>
}