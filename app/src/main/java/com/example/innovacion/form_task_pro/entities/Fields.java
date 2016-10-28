package com.example.innovacion.form_task_pro.entities;

/**
 * Created by innovacion on 26-10-2016.
 */

public class Fields {

    public String key;
    public String type;
    public String hint;
    public String step;

    public Fields() {
    }

    public Fields(String key, String type, String hint, String step) {
        this.key = key;
        this.type = type;
        this.hint = hint;
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
