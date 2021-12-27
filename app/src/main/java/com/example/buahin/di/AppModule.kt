package com.example.buahin.di

import com.example.buahin.repository.AuthRepository
import com.example.buahin.repository.CartRepository
import com.example.buahin.repository.CategoryRepository
import com.example.buahin.repository.ProductRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(firestore: FirebaseFirestore): CategoryRepository {
        return CategoryRepository(firestore)
    }

    @Provides
    @Singleton
    fun provideProductRepository(firestore: FirebaseFirestore): ProductRepository {
        return ProductRepository(firestore)
    }

    @Provides
    @Singleton
    fun providerAuthRepository(fireauth: FirebaseAuth): AuthRepository {
        return AuthRepository(fireauth)
    }

    @Provides
    @Singleton
    fun providerCartRepository(firestore: FirebaseFirestore): CartRepository {
        return CartRepository(firestore)
    }
}