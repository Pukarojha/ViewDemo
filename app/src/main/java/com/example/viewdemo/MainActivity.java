package com.example.viewdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewSample ;
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
        TextView txtViewSample = findViewById(R.id.txtViewSample);
        imgViewSample = findViewById(R.id.imgViewSample);
        Button btnShowImgorText = findViewById(R.id.btnShowImgorText);
        Button btnShowBoth = findViewById(R.id.btnShowBoth);

        Drawable img = ResourcesCompat.getDrawable(getResources(), R.drawable.border,getTheme());
        //so here ResourcesCompat.getDrawable(): used to load drawable resources like img, shape, etc
        // In this case, it's loading drawable.border.
        //getResources(): retrives the resources associated with (like Strings, colors, etc)
        //getTheme(): gets the theme of current activity

        img.setBounds(0,0,80,80);

        //setBounds(0,0,80,80); here means:
        //L, T is 0, 0, R, B is 80, 80
        //which basically means draw an image from left, top 0, 0 to Right 80, Bottom 80
        //which simplifies to width of 80 and height of 80
    }
}