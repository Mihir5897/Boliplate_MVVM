package com.me.boliplate_mvvm.service.model;

import android.content.Context;

//import androidx.room.Room;
//
//import com.me.boliplate_mvvm.service.api.ApiService;
//import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDao;
//import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDataBase;
//import com.me.boliplate_mvvm.utility.LiveDataCallAdapterFactory;
//import com.me.boliplate_mvvm.utility.constant.AppConstants;
//import com.me.boliplate_mvvm.view.ui.login.ActivityLogin;
//
//import javax.inject.Named;
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//import dagger.hilt.InstallIn;
//import dagger.hilt.android.qualifiers.ApplicationContext;
//import dagger.hilt.components.SingletonComponent;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//@Module
//@InstallIn(SingletonComponent.class)
public class AppModule {
//    @Singleton
//    @Provides
//    String getBaseUrl(){
//        return AppConstants.BASE_URL;
//    }
//    @Singleton
//    @Provides
//    Retrofit getRetrofit(String BaseUrl){
//        return  new Retrofit.Builder()
//                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create()).build();
//    }
//    ApiService getApiService(Retrofit retrofit){
//        return retrofit.create(ApiService.class);
//    }
//    @Singleton
//    @Provides
//    @Named("bdname")
//    String getDBName(){
//        return "mi-database.db";
//    }
//    @Singleton
//    @Provides
//    UserDataBase getRoomDb(@ApplicationContext Context context, @Named("bdname")String roomName){
//        return Room.databaseBuilder(context, UserDataBase.class, roomName)
//                .allowMainThreadQueries()
//                .build();
//    }
//    @Singleton
//    @Provides
//    UserDao getUserDao(UserDataBase db){
//        return db.getUserDao();
//    }
   }
