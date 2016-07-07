package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.Doc;

import java.io.IOException;
import java.util.List;

public interface NYTimesService {
    List<Doc> getArticles() throws IOException;
}
