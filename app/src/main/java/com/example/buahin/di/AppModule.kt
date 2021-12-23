package com.example.buahin.di

import com.example.buahin.repository.CategoryRepository
import com.example.buahin.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCategoryRepository() : CategoryRepository {
        return CategoryRepository()
    }

    @Provides
    @Singleton
    fun provideProductRepository() : ProductRepository {
        return ProductRepository()
    }
}