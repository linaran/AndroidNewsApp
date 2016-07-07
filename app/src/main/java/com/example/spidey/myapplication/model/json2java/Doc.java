package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public final class Doc {
    @SerializedName("web_url")
    @Expose
    private String webUrl;

    @SerializedName("snippet")
    @Expose
    private String snippet;

    @SerializedName("lead_paragraph")
    @Expose
    private String leadParagraph;

    @SerializedName("abstract")
    @Expose
    private Object _abstract;

    @SerializedName("print_page")
    @Expose
    private Object printPage;

    @SerializedName("blog")
    @Expose
    private List<Object> blog = new ArrayList<>();

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("multimedia")
    @Expose
    private List<Multimedium> multimedia = new ArrayList<>();

    @SerializedName("headline")
    @Expose
    private Headline headline;

    @SerializedName("keywords")
    @Expose
    private List<Object> keywords = new ArrayList<>();

    @SerializedName("pub_date")
    @Expose
    private String pubDate;

    @SerializedName("document_type")
    @Expose
    private String documentType;

    @SerializedName("news_desk")
    @Expose
    private String newsDesk;

    @SerializedName("section_name")
    @Expose
    private String sectionName;

    @SerializedName("subsection_name")
    @Expose
    private Object subsectionName;

    @SerializedName("type_of_material")
    @Expose
    private String typeOfMaterial;

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("word_count")
    @Expose
    private String wordCount;

    @SerializedName("slideshow_credits")
    @Expose
    private Object slideshowCredits;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public Object getAbstract() {
        return _abstract;
    }

    public void setAbstract(Object _abstract) {
        this._abstract = _abstract;
    }

    public Object getPrintPage() {
        return printPage;
    }

    public void setPrintPage(Object printPage) {
        this.printPage = printPage;
    }


    public List<Object> getBlog() {
        return blog;
    }

    public void setBlog(List<Object> blog) {
        this.blog = blog;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<Object> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }


    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Object getSubsectionName() {
        return subsectionName;
    }

    public void setSubsectionName(Object subsectionName) {
        this.subsectionName = subsectionName;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public Object getSlideshowCredits() {
        return slideshowCredits;
    }

    public void setSlideshowCredits(Object slideshowCredits) {
        this.slideshowCredits = slideshowCredits;
    }
}
