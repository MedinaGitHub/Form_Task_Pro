package com.example.innovacion.form_task_pro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.innovacion.form_task_pro.R;
import com.example.innovacion.form_task_pro.adapter.FieldsAdapter;
import com.example.innovacion.form_task_pro.entities.Fields;
import com.example.innovacion.form_task_pro.entities.Form;
import com.example.innovacion.form_task_pro.entities.Steps;

import java.util.ArrayList;
import java.util.List;

import utils.CommonUtils;

/**
 * Created by innovacion on 26-10-2016.
 */

public class FieldsPagerFragment extends Fragment {

    private String title;
    private int page;
    private int step;
    private RecyclerView recycler;
    private FieldsAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    Button btn;


    public static Fragment newInstance(int page, String title) {
        FieldsPagerFragment fragmentFirst = new FieldsPagerFragment();
        Bundle args = new Bundle();

        args.putInt("someInt", page);
        args.putString("someTitle", title);

        //Validadando si es la ultima pagina para añadir el boton de enviar.

        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        step = page;
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        String nStep = getArguments().getString("Nstep");



        // Obtener el Recycler view
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        String json = CommonUtils.loadJSONFromAsset(getContext(), "data.json");


        Form estructure;
        estructure = Form.obtieneRespuesta(json);
        List<Fields> field = new ArrayList<Fields>();


        //String key, String type, String hint, String step
         //fieldButton("btnSend","button","Send",nStep);

        for (Steps s : estructure.steps){

            String val = s.getStep().toString();
            String val2 = s.getStep();
            String ult;

            if(val.equals(nStep)){//si el step del fragment corresponde al step de la lista lo agrego a un List para enviarlo al RecyclerView

                field = s.getFields();
                ult = s.getStep();
                if(estructure.count.equals(ult)){
                    Fields fieldButton = new Fields("btnSend","button","Send",nStep);
                    field.add(fieldButton);
                }
            }
        }

        //crear un nuevo adaptador
        adapter = new FieldsAdapter(field,getContext());//le paso al adaptador la lista de datos y la posicion correspondiente al elemento
        adapter.setOnTextChangeListener(new FieldsAdapter.TextChangeListener() {
            @Override
            public void onTextChange() {
                Log.d("OnTextChange", "action");
            }
        });
        recycler.setAdapter(adapter);



        return view;
    }

}
