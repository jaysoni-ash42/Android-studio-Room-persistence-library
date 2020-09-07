package com.example.sql.sql;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class Usersschema {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="username")
    private String username;
    @ColumnInfo(name="email")
    private String email;
    @ColumnInfo(name="address")
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Ignore
    public Usersschema(int id, String username, String email, String address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public Usersschema(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public Usersschema()
    {

    }
}
