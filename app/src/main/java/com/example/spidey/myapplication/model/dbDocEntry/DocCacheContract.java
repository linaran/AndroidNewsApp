package com.example.spidey.myapplication.model.dbDocEntry;

import android.provider.BaseColumns;

// Database contracts
public final class DocCacheContract {

    private DocCacheContract() {
    }

    //    Table contract
    public static abstract class DocEntry implements BaseColumns {
        public static final String TABLE_NAME = "doc_entry";
        public static final String COLUMN_NAME_DOC_ID = "doc_id";
        public static final String COLUMN_NAME_MAIN_HEADLINE = "main_headline";
        public static final String COLUMN_NAME_IMAGE_RELATIVE_URL = "image_relative_url";
        public static final String COLUMN_NAME_LEAD_PARAGRAPH = "lead_paragraph";
    }
}
