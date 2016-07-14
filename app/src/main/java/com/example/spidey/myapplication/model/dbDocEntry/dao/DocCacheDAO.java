package com.example.spidey.myapplication.model.dbDocEntry.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.spidey.myapplication.model.dbDocEntry.DocCacheContract.DocEntry;
import com.example.spidey.myapplication.model.dbDocEntry.DocCacheDbHelper;
import com.example.spidey.myapplication.model.net.json2java.Doc;
import com.example.spidey.myapplication.model.net.json2java.Multimedium;

import java.lang.ref.WeakReference;
import java.util.List;

public final class DocCacheDAO {

    private final SQLiteDatabase sqLiteDatabase;

    public DocCacheDAO(DocCacheDbHelper dbHelper) {
        this.sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void addDoc(Doc document, AddDocCallback callback) {

    }

    private final class addDocAsyncTask extends AsyncTask<Doc, Void, Boolean> {

        private final WeakReference<AddDocCallback> callback;

        private addDocAsyncTask(AddDocCallback callback) {
            this.callback = new WeakReference<>(callback);
        }

        @Override
        protected Boolean doInBackground(Doc... params) {
            Doc newDocEntry = params[0];

            ContentValues values = new ContentValues();
            values.put(DocEntry.COLUMN_NAME_MAIN_HEADLINE, newDocEntry.getHeadline().getMain());
            values.put(DocEntry.COLUMN_NAME_LEAD_PARAGRAPH, newDocEntry.getLeadParagraph());
            List<Multimedium> multimedia = newDocEntry.getMultimedia();
            if (multimedia != null && multimedia.size() != 0) {
                values.put(DocEntry.COLUMN_NAME_IMAGE_RELATIVE_URL, multimedia.get(0).getUrl());
            }

//            TODO: Do SQL magic.

            throw new UnsupportedOperationException("You're not done coding trololo.");
        }
    }
}
