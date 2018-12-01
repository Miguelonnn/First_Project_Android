package com.example.mikel.miprimeraaplicacion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends MainMenu {
    TextView textView;
    private int[] photos = {R.drawable.m5, R.drawable.gle, R.drawable.forsennato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<Car> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));


// When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Car coche = (Car) o;

                final ImageView image = new ImageView(MyListActivity.this);
                image.setImageResource(photos[position]);

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MyListActivity.this);
                builder.setTitle(((Car) o).getNom_coche());
                builder.setMessage("Modelo: "+((Car) o).getModelo_coche());
                builder.setView(image);
                builder.setPositiveButton(getString(R.string.text_ok), null);
                builder.create();
                builder.show();

            }
        });

    }
    private  List<Car> getListData(){
        List<Car> list = new ArrayList<Car>();
        Car bmw = new Car("bmw", "M5","BMW");
        Car mercedes = new Car("mercedes", "LGE80","MERCEDES");
        Car lamborgini = new Car("lamborgini", "Forsannato","LAMBORGHINI");


        list.add(bmw);
        list.add(mercedes);
        list.add(lamborgini);

        return list;
    }

}

