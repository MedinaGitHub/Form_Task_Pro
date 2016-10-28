package com.example.innovacion.form_task_pro;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.example.innovacion.form_task_pro.entities.Form;
import com.example.innovacion.form_task_pro.fragment.FieldsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import utils.CommonUtils;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout tabs;
    private static final String DATA_JSON_PATH        = "data.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dynamic_form();//Este metodo y los que contengan a dentro juntos con los campos poner dentro del onCreate de la futura activity en la que este esta funcionalidad.

        setToolbar();

    }

    public void dynamic_form(){

        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);// id.pager esta en el layout de activity_main
        setupViewPager(mViewPager);


        // Preparar las pestañas elementos de la libreria de diseño.
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);

    }


    /*
     Crea una instancia del view pager con los datos del json form
     @param viewPager Nueva instancia
    */
    public void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());


        String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH); //Posteriormente el String json se llenaria con la respuesta del WS.


        Form estructure;
        estructure = Form.obtieneRespuesta(json); //metodo previsorio para transformar un string json en un formato, cuando viene desde retrofit no aplica el From.obtieneRespuesta, sino response.body y luego al data guardar en la bd


        int count = Integer.parseInt(estructure.count);

        for(int i = 0; i < count; i++)
        {
            int page = i+1;
            adapter.addFragment(FieldsPagerAdapter.newInstance(page, null), "nº"+page, page);

        }
        viewPager.setAdapter(adapter);

    }


    /*
 Un {@link FragmentPagerAdapter} que gestiona las secciones, fragmentos y
 títulos de las pestañas
 */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title ,int nStep) {

            mFragments.add(fragment);
            mFragmentTitles.add(title);
            Bundle bundle = new Bundle();
            bundle.putString("Nstep", String.valueOf(nStep)); //Envio al fragment el numero de step que se esta viendo para poder filtrar mas facilemtne
            fragment.setArguments(bundle);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }


    }



    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

    }

}
