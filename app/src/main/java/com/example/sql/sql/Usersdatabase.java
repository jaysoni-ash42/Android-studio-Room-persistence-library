package com.example.sql.sql;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.nio.file.attribute.UserDefinedFileAttributeView;

@Database(entities = Usersschema.class,version = 1,exportSchema = false)
public abstract class Usersdatabase extends RoomDatabase {
    private static Usersdatabase INSTANCE;
    public abstract Dao dao();
    private static String DB_name="Users_database";
    public static synchronized Usersdatabase getInstance(Context mcontetx)
    {
        if(INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(mcontetx,Usersdatabase.class,DB_name).build();
        }
        return INSTANCE;


    }


}
