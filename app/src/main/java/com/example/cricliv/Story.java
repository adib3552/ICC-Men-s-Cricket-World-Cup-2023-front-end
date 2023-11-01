package com.example.cricliv;

public class Story {
    private String hline;
    private String intro;

    public Story(String hline, String intro) {
        this.hline = hline;
        this.intro = intro;
    }

    public String getHline() {
        return hline;
    }

    public void setHline(String hline) {
        this.hline = hline;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
