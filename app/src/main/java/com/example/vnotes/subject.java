package com.example.vnotes;

public class subject {
    String sub_name;
    String sub_code;

    public subject(String sub_name, String sub_code) {
        this.sub_name = sub_name;
        this.sub_code = sub_code;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }
}
