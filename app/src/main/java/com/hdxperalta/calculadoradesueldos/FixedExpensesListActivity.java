package com.hdxperalta.calculadoradesueldos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FixedExpensesListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_expenses_list);

        ListView listView = findViewById(R.id.fixedExpensesList);

        ArrayList<String> listItems;
        listItems = getIntent().getStringArrayListExtra("LIST_ITEMS");
        String titleBar = getIntent().getStringExtra("TITLE");
        getSupportActionBar().setTitle(titleBar);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.my_text_view,
                listItems);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {

            AlertDialog alertDialog = new AlertDialog.Builder(FixedExpensesListActivity.this)
                    .setTitle("ATENCION")
                    .setMessage("¿Desea eliminar este gasto?")
                    .setPositiveButton("ACEPTAR", (dialogInterface, i) -> {
                        listItems.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("listItem", listItems);
                        setResult(RESULT_OK, intent);

                        Toast.makeText(FixedExpensesListActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();
                    })
                    .setNegativeButton("CANCELAR", (dialogInterface, i) -> {
                    })
                    .create();
            alertDialog.show();
        });
    }
}
