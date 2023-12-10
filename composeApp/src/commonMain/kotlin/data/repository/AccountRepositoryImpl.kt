package data.repository

import data.AccountRepository
import data.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

class AccountRepositoryImpl(
    private val dataStoreOperations: DataStoreOperations
): AccountRepository, KoinComponent {
    override suspend fun saveOnboardingState(completed: Boolean) {
        dataStoreOperations.saveOnboardingState(completed)
    }

    override fun readOnboardingState(): Flow<Boolean> {
        return dataStoreOperations.getOnboardingState()
    }
}