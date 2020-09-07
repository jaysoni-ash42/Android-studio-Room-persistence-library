package com.example.sql.sql;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class Repository {
    private Dao dao;
    Context mcontext;
    private static List<Usersschema> users;

    public Repository(Context context) {
        this.mcontext = context;
        dao = Usersdatabase.getInstance(mcontext).dao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                users=dao.getall();
            }
        }).start();

        Log.d("data",String.valueOf(users));

    }

    public void insertdata(Usersschema users) {
        new insertdata(dao).execute(users);

    }

    public List<Usersschema> getall() {
        return users;
    }

    static class insertdata extends AsyncTask<Usersschema, Void, Void> {
        Dao dao;

        public insertdata(Dao dao) {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(Usersschema... users) {
            dao.insertitem(users[0]);
            return null;
        }
    }

}
