package com.example.task_scheduler;

import android.app.Application;

import androidx.room.Room;

import com.example.task_scheduler.data.AppDataBase;
import com.example.task_scheduler.data.NoteDao;

public class App extends Application {

    private AppDataBase database;
    private NoteDao noteDao;


    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "app-db-ts")
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }

    public AppDataBase getDatabase() {
        return database;
    }

    public void setDatabase(AppDataBase database) {
        this.database = database;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
