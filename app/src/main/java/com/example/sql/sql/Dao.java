package com.example.sql.sql;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.sql.model.Usersdata;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertitem(Usersschema usersdata);

    @Query("select * from users")
    List<Usersschema> getall();

}
