package data

import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun saveOnboardingState(completed: Boolean)
    fun readOnboardingState(): Flow<Boolean>
}