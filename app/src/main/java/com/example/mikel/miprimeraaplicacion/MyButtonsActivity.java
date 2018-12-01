package com.example.mikel.miprimeraaplicacion;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.AlertDialog;

public class MyButtonsActivity extends MainMenu {

    Switch switchButton;
    ImageButton imageButton;
    ToggleButton toggleButton;
    RadioGroup radioGroup;
    RadioButton radioButton;
    boolean ON = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_buttons);
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

        switchButton = (Switch) findViewById(R.id.switch1);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageButton = findViewById (R.id.imageButton);
                toggleButton = findViewById (R.id.toggleButton);
                radioGroup = findViewById (R.id.radioGroup);
                if(isChecked){
                    switchButton.setText(R.string.switch_on);
                    imageButton.setVisibility(View.VISIBLE);
                    toggleButton.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                }
                else{
                    switchButton.setText(R.string.switch_off);
                    imageButton.setVisibility(View.INVISIBLE);
                    toggleButton.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    public void imageButtonONOFF(View view) {
        if (ON) {
            imageButton.setImageResource(R.drawable.boto_off);
            ON = false;
        }
        else {
            imageButton.setImageResource(R.drawable.boto_on);
            ON = true;
        }
    }

        public void changeRadiobutton (View view) {
            radioButton = findViewById (view.getId());
            AlertDialog.Builder builder = new AlertDialog.Builder(MyButtonsActivity.this);
            builder.setTitle(getString(R.string.title_message_radiobutton));
            builder.setMessage(getString(R.string.text_message_radiobutton)+ radioButton.getText());
            builder.setNeutralButton(getString(R.string.text_button_cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {
                    radioButton.setChecked(false);
                }
            });
            builder.setPositiveButton(getString(R.string.text_button_yes),new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {
                    radioButton.setChecked(true);
                }
            });
            builder.create();
            builder.show();
        }

    public void toggleButtonONOFF(View view) {
        Toast.makeText(getApplicationContext(),getString(R.string.tooglebutton_toasttext),Toast.LENGTH_LONG).show();

    }
}


