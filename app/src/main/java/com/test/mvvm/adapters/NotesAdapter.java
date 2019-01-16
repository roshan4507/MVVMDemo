package com.test.mvvm.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.test.mvvm.R;
import com.test.mvvm.database.models.Note;
import com.test.mvvm.utils.DateConverter;

/*
Created By WANIRO-CONT On 12/13/2018  
*/
public class NotesAdapter extends RecyclerView.Adapter {
    //Create list of notes
    List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Get layout inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //Inflate layout
        View row = inflater.inflate(R.layout.custom_row_note, parent, false);
        //return notes holder and pass row inside
        return new NoteHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Get current note
        Note currentNote = notes.get(position);
        //cast notes holder
        NoteHolder noteHolder = (NoteHolder) holder;
        //set title description and created at
        noteHolder.mNoteTitle.setText(currentNote.getNoteTitle());
        noteHolder.mNoteDescription.setText(currentNote.getNoteDescription());
        noteHolder.createdAt.setText(DateConverter.getDayMonth(currentNote.getCreatedAt()));
        //create random color and set it
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        noteHolder.backStrip.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        TextView mNoteTitle, mNoteDescription, createdAt;
        FrameLayout backStrip;

        public NoteHolder(View itemView) {
            super(itemView);
            mNoteTitle = itemView.findViewById(R.id.noteTitle);
            mNoteDescription = itemView.findViewById(R.id.noteDescription);
            createdAt = itemView.findViewById(R.id.createdAt);
            backStrip = itemView.findViewById(R.id.backStrip);
        }
    }

    public void addNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }
}
