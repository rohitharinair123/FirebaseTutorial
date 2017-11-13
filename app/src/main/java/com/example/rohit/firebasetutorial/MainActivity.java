package com.example.rohit.firebasetutorial;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static final String TAG = "T";
    public static final String KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void saveName(View view) {
        EditText name = (EditText) findViewById(R.id.edit_text_view);
        String nameText = name.getText().toString();
        DatabaseReference myRef = database.getReference("name");
        if (nameText.isEmpty()) { return; }
        myRef.setValue(nameText);
        name.getText().clear();

    }
    public void displayName(View view) {
        Intent intent = new Intent(this, DisplayNameActivity.class);
        startActivity(intent);
    }
}
