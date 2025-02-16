package com.example.viewdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try{
            int number = Integer.parseInt("23.58");
        }catch (Exception e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();;
            Log.d("Gesture Demo", "Some Error Occoured");
            e.printStackTrace(System.err);
            Log.d("Gesture Demo", Log.getStackTraceString(e));
        }
    }
}