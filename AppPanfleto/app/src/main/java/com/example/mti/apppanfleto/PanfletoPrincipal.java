package com.example.mti.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PanfletoPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panfleto_principal);
        ListView  listView;
        ArrayAdapter <String> adapter;
        listView = (ListView)findViewById(R.id.list_item);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);
        adapter.add(getResources().getString(R.string.temas));
        adapter.add(getResources().getString(R.string.Actividades));
        adapter.add(getResources().getString(R.string.eval));
        adapter.add(getResources().getString(R.string.progress));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int option = position;
                Intent intent  = new Intent(PanfletoPrincipal.this,ProductosActivity.class);

                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), "Opcion...."+option, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent  = new Intent(PanfletoPrincipal.this,ProductosActivity.class);
        switch (item.getItemId()){
            case R.id.itemtemas:
                Toast.makeText(this, "temas", Toast.LENGTH_SHORT).show();
                intent.putExtra("OPCION",0);
                startActivity(intent);
                finish();
                return true;
            case R.id.itemEval:
                Toast.makeText(this, "Eval", Toast.LENGTH_SHORT).show();
                intent.putExtra("OPCION",1);
                startActivity(intent);
                finish();
                return true;
            case R.id.itemActivs:
                Toast.makeText(this, "Activs", Toast.LENGTH_SHORT).show();
                intent.putExtra("OPCION",2);
                startActivity(intent);
                finish();
                return true;
            case R.id.itemProgress:
                Toast.makeText(this, "Progress", Toast.LENGTH_SHORT).show();
                intent.putExtra("OPCION",3);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
