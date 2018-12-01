package com.example.mikel.miprimeraaplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainMenu extends AppCompatActivity {
    private String URLLevant ="https://www.levante-emv.com";
    private String URLElDario ="https://www.eldiario.es";
    private String pagina_Levante="LEVANTE EMV";
    private String pagina_ElDiario="EL DIARIO.ES";


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(id == R.id.menuLevante){
            Intent intent = new Intent(this, MyWebsitesActivity.class);
            Bundle b = new Bundle();
            b.putString("url", URLLevant);
            b.putString("title", pagina_Levante);
            intent.putExtras(b);
            startActivity(intent);
        }
        if(id == R.id.menuEldiario){
            Intent intent = new Intent(this, MyWebsitesActivity.class);
            Bundle b = new Bundle();
            b.putString("url", URLElDario);
            b.putString("title", pagina_ElDiario);
            intent.putExtras(b);
            startActivity(intent);
        }
        if (id == R.id.mybuttons) {
            Intent intent = new Intent(this, MyButtonsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.mylist) {
            Intent intent = new Intent(this, MyListActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

