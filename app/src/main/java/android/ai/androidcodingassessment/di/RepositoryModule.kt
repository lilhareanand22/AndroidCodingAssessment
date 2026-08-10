package android.ai.androidcodingassessment.di

import android.ai.androidcodingassessment.data.repository.PostRepositoryImp
import android.ai.androidcodingassessment.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(
        postRepositoryImp: PostRepositoryImp
    ): PostRepository
}