package com.example.week9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;

    Button mButton1, mButton2, mButton3;

    ListView mListView;

    SQLitedb sqLitedb = new SQLitedb(MainActivity.this);

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextText);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mListView = findViewById(R.id.listview);

        sqLitedb.curosr();
        listviewupdate();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {
                sqLitedb.cursor.moveToPosition(position);
                id = sqLitedb.cursor.getInt(0);
                mEditText.setText(sqLitedb.cursor.getString(1));
            }
        });

    }

    private void listviewupdate() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                sqLitedb.select()
        );
        mListView.setAdapter(adapter);
        mEditText.setText("");
    }

    public void onDataAdd(View view) {
        sqLitedb.insert(mEditText.getText().toString());
        listviewupdate();
    }

    public void onDataDelete(View view) {
        sqLitedb.delete(id);
        listviewupdate();
    }

    public void onDataModify(View view) {
        sqLitedb.update(id, mEditText.getText().toString());
        listviewupdate();
    }
}