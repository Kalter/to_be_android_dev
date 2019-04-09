package com.akvelon.myfirstapp.lesson6.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM roomuserinfo")
    List<RoomUserInfo> getAll();

    @Query("SELECT * FROM roomuserinfo WHERE age >= 18")
    List<RoomUserInfo> loadByAges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(RoomUserInfo... users);

    @Delete
    void delete(RoomUserInfo user);

}
