package com.example.buahin.di

import com.example.buahin.repository.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
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
    @Named("UUID")
    fun provideUUID(fireauth: FirebaseAuth): String {
        return fireauth.currentUser?.uid ?: ""
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
    fun providerCartRepository(
        @Named("UUID") uuid: String,
        firestore: FirebaseFirestore
    ): CartRepository {
        return CartRepository(uuid, firestore)
    }

    @Provides
    @Singleton
    fun provideOrderRepository(
        @Named("UUID") uuid: String,
        firestore: FirebaseFirestore,
        cartRepository: CartRepository,
    ): OrderRepository {
        return OrderRepository(uuid, firestore, cartRepository)
    }
}