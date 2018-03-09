package com.hdxperalta.calculadoradesueldos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class FixedExpensesListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_expenses_list);

        ListView listView = findViewById(R.id.fixedExpensesList);

        ArrayList<String> listItems;
        listItems = getIntent().getStringArrayListExtra("LIST_ITEMS");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.my_text_view,
                listItems);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                // TODO Auto-generated method stub

                listItems.remove(position);

                arrayAdapter.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putStringArrayListExtra("listItem", listItems);
                setResult(RESULT_OK, intent);

                Toast.makeText(FixedExpensesListActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();

                return true;

            }

        });
    }

}
