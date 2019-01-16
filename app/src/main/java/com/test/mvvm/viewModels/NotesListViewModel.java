package com.test.mvvm.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.test.mvvm.database.models.Note;
import com.test.mvvm.repositories.NotesRepository;

import java.util.List;

/*
Created By WANIRO-CONT On 12/13/2018  
*/
public class NotesListViewModel extends AndroidViewModel {
    private LiveData<List<Note>> mAllNotes;
    NotesRepository mNotesRepository;

    public NotesListViewModel(@NonNull Application application) {
        super(application);
        mNotesRepository = new NotesRepository(application);
        mAllNotes = mNotesRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public void addNote(Note note) {
        mNotesRepository.addNote(note);
    }


}
