package com.example.task_scheduler.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.task_scheduler.model.Note;

import java.util.List;

// объект, через который будет осуществляться доступ к таблице БД (запись, чтение и тд)
@Dao // запросы
public interface NoteDao {
    @Query("SELECT * FROM Note")
    List<Note> getAll();

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllLiveData();

    @Query("SELECT * FROM Note WHERE uid IN (:userIds)")
    List<Note> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Note WHERE uid = :uid LIMIT 1")
    Note findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE) // замена старой заметки на новую
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
