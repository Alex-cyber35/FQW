package com.example.task_scheduler.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.task_scheduler.model.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();

}