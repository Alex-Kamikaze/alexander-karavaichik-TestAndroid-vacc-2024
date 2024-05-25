package com.alexkarav.testandroidvacc24.di

import android.content.Context
import androidx.room.Room
import com.alexkarav.testandroidvacc24.data.local.datastore.DataStoreManager
import com.alexkarav.testandroidvacc24.data.local.db.AppDatabase
import com.alexkarav.testandroidvacc24.data.remote.ShopListApi
import com.alexkarav.testandroidvacc24.domain.repo.ProductRepositoryImpl
import com.alexkarav.testandroidvacc24.domain.repo.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_db.sqlite").build()
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Provides
    @Singleton
    fun provideStoreApi(): ShopListApi {
        return Retrofit.Builder()
            .baseUrl(ShopListApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShopListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(dataStoreManager: DataStoreManager, appDatabase: AppDatabase, api: ShopListApi): UserRepositoryImpl {
        return UserRepositoryImpl(dataStoreManager = dataStoreManager, appDatabase = appDatabase, shopListApi = api)
    }

    @Provides
    @Singleton
    fun provideProductRepository(shopListApi: ShopListApi): ProductRepositoryImpl {
        return ProductRepositoryImpl(shopListApi)
    }
}