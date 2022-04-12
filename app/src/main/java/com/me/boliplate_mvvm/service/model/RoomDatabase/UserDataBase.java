package com.me.boliplate_mvvm.service.model.RoomDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.me.boliplate_mvvm.service.model.entity.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}

