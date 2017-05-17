package com.example.fikid.itschilliv3;

/**
 * Created by FIKID on 5/15/2017.
 */

public class berita {
    private String judulBerita;
    private String deskBerita;
    private String date;
    private String url;

    private String idImage;

    public berita(String judulBerita, String deskBerita, String date, String url, String idImage) {
        this.judulBerita = judulBerita;
        this.deskBerita = deskBerita;
        this.date = date;
        this.url = url;
        this.idImage = idImage;
    }

    public String getJudulBerita() {
        return judulBerita;
    }

    public String getDeskBerita() {
        return deskBerita;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getIdImage() {
        return idImage;
    }
}
