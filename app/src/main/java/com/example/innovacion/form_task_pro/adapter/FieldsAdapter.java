package com.example.innovacion.form_task_pro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.innovacion.form_task_pro.R;
import com.example.innovacion.form_task_pro.entities.Fields;

import java.util.List;

/**
 * Created by innovacion on 26-10-2016.
 */


public class FieldsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    public static final int  edite_text = 0;
    public static final int  label = 1;
    public static final int  check_box = 2;
    public static final int  spinner = 3;
    public static final int  radio = 4;
    public static final int  button = 5;
    public String responsetxt[];
    public String responseall[];
    protected String[] mDataset;



    private Context context;
    private static final String TAG = "adapter";
    List<Fields> items;
    private String arrayForSaveEditTextValue[];

    public FieldsAdapter(List<Fields> items,Context context){

        super();
        this.items = items;
        this.context = context;

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case edite_text:
                View v1 = inflater.inflate(R.layout.edit_text_layout,parent,false);
                viewHolder = new ViewHolderTxt(v1);
                break;
            case label:
                View v2 = inflater.inflate(R.layout.label_layout,parent,false);
                viewHolder = new ViewHolderLbl(v2);
                break;
            case check_box:
                View v3 = inflater.inflate(R.layout.check_box_layout,parent,false);
                viewHolder = new ViewHolderChk(v3);
                break;
            case spinner:
                View v4 = inflater.inflate(R.layout.spinner_layout,parent,false);
                viewHolder = new ViewHolderSpinner(v4);
                break;
            case radio:
                View v5 = inflater.inflate(R.layout.radio_layout,parent,false);
                viewHolder = new ViewHolderRbt(v5);
                break;
            case button:
                View v6 = inflater.inflate(R.layout.button_layout,parent,false);
                viewHolder = new ViewHolderBtn(v6);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new RecyclerViewSimpleTextViewHolder(v);
                break;
        }

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case edite_text:
                ViewHolderTxt vh1 = (ViewHolderTxt) viewHolder;
                configureViewHolderTxt(vh1, position);
                break;
            case label:
                ViewHolderLbl vh2 = (ViewHolderLbl) viewHolder;
                configureViewHolderLbl(vh2, position);
                break;
            case check_box:
                ViewHolderChk vh3 = (ViewHolderChk) viewHolder;
                configureViewHolderChk(vh3, position);
                break;
            case spinner:
                ViewHolderSpinner vh4 = (ViewHolderSpinner) viewHolder;
                configureViewHolderSpinner(vh4, position);
                break;
            case radio:
                ViewHolderRbt vh5 = (ViewHolderRbt) viewHolder;
                configureViewHolderRbt(vh5, position);
                break;
            case button:
                ViewHolderBtn vh6 = (ViewHolderBtn) viewHolder;
                configureViewHolderBtn(vh6, position);
                break;
            default:
                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
                configureDefaultViewHolder(vh, position);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        items.get(position);
        String item = items.get(position).getType();
        if (item.equals("edit_text")) {
            return edite_text;
        } else if (item.equals("label")) {
            return label;
        }
        else if (item.equals("check_box")) {
            return check_box;
        }
        else if (item.equals("spinner")) {
            return spinner;
        }
        else if (item.equals("radio")) {
            return radio;
        }
        else if (item.equals("button")) {
            return button;
        }
        return -1;
    }


    //The following methods are used for configuring the individual RecyclerView.ViewHolder objects:
    private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
        //   vh.getLabel().setText((CharSequence) items.get(position));
    }

    private void configureViewHolderTxt(ViewHolderTxt vh1, final int position) {



        Fields field = (Fields) items.get(position);
       // responsetxt = new String[] {field.getKey()};
              vh1.edit_txt.setHint(field.getHint());


        //   vh1.edit_txt.setText(arrayForSaveEditTextValue[position]);

        //String txt = vh1.edit_txt.getText().toString();
        //responsetxt = new String[] {txt};
/*
        vh1.edit_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // responsetxt[mDataset[position]] = s.toString();
               // holder.view.setTag(position);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
*/
    }

    private void configureViewHolderLbl(ViewHolderLbl vh2, int position) {
        vh2.label.setText("Correspondo a un Label");

    }


    private void configureViewHolderChk(ViewHolderChk vh3, int position) {
        //vh2.label.setText("Correspondo a un Label");
    }

    private void configureViewHolderSpinner(ViewHolderSpinner vh4, int position) {
        //vh2.label.setText("Correspondo a un Label");
    }

    private void configureViewHolderRbt(ViewHolderRbt vh5, int position) {
        //vh2.label.setText("Correspondo a un Label");
    }

    private void configureViewHolderBtn(ViewHolderBtn vh6, int position) {

        vh6.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responseall = arrayForSaveEditTextValue;

                Log.d("ÑE","ÑE");


            }
        });

    }


    @Override
    public int getItemCount() {
        int DATASET_COUNT = items.size();
        mDataset = new String[items.size()];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "" + i;
        }
        return items.size();
    }

    //-Un ViewHolder es un objeto que representa un ítem de la lista,
    // el cual almacena las referencias de los views dentro del layout con propósitos de acceso rápido.
    // Este objeto es la comunicación directa entre el LayoutManager y el adaptador, actuando como caché.
    public static class AdaptadorViewHolder extends  RecyclerView.ViewHolder{
        //campos respectivos de un item , Referencias UI



        public AdaptadorViewHolder(View v){
            super(v);

        }

    }




    public class ViewHolderTxt extends RecyclerView.ViewHolder {

        private TextView edit_txt;

        public ViewHolderTxt(View v) {
            super(v);
            edit_txt = (TextView) v.findViewById(R.id.id_editText);
        }

        public TextView getEdit_txt() {
            return edit_txt;
        }

        public void setEdit_txt(TextView edit_txt) {
            this.edit_txt = edit_txt;
        }

    }



    public class ViewHolderLbl extends RecyclerView.ViewHolder {

        private TextView label;


        public ViewHolderLbl(View v) {
            super(v);
            label = (TextView) v.findViewById(R.id.id_textView);
        }

        public TextView getLabel() {
            return label;
        }

        public void setLabel(TextView label) {
            this.label = label;
        }
    }


    public class ViewHolderChk extends RecyclerView.ViewHolder {

        private CheckBox chk;


        public ViewHolderChk(View v) {
            super(v);

        }

        public CheckBox getChk() {
            return chk;
        }

        public void setChk(CheckBox chk) {
            this.chk = chk;
        }
    }

    public class ViewHolderSpinner extends RecyclerView.ViewHolder {

        private Spinner select;


        public ViewHolderSpinner(View v) {
            super(v);

        }

        public Spinner getSelect() {
            return select;
        }

        public void setSelect(Spinner select) {
            this.select = select;
        }
    }

    public class ViewHolderRbt extends RecyclerView.ViewHolder {

        private RadioButton rbt;


        public ViewHolderRbt(View v) {
            super(v);

        }

        public RadioButton getRbt() {
            return rbt;
        }

        public void setRbt(RadioButton rbt) {
            this.rbt = rbt;
        }
    }

    public class ViewHolderBtn extends RecyclerView.ViewHolder {

        private Button btn;


        public ViewHolderBtn(View v) {
            super(v);
            btn = (Button) v.findViewById(R.id.id_button);

        }

        public Button getBtn() {
            return btn;
        }

        public void setBtn(Button btn) {
            this.btn = btn;
        }
    }


    private class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder {


        public RecyclerViewSimpleTextViewHolder(View itemView) {
            super(itemView);
        }
    }


}
