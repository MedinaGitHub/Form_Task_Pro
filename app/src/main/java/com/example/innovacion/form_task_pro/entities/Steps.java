package com.example.innovacion.form_task_pro.entities;

import java.util.ArrayList;

/**
 * Created by innovacion on 26-10-2016.
 */

public class Steps {

    private String title;
    private String step;
    private ArrayList<Fields> fields;

    public Steps(String title, String step, ArrayList<Fields> fields) {
        this.title = title;
        this.step = step;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public ArrayList<Fields> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Fields> fields) {
        this.fields = fields;
    }
}
