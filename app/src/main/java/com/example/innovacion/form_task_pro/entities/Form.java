package com.example.innovacion.form_task_pro.entities;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by innovacion on 26-10-2016.
 */

public class Form {
    public String idForm;
    public String count;
    public ArrayList<Steps> steps;

    public Form(String idForm, String count, ArrayList<Steps> steps) {
        this.idForm = idForm;
        this.count = count;
        this.steps = steps;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<Steps> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Steps> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Form obtieneRespuesta(String json){

        Gson gson = new Gson();
        Form form = gson.fromJson(json,Form.class);
        return form;
    }

}
