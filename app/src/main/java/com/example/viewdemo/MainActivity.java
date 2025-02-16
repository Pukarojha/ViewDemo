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

import java.util.Objects;

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

        Objects.requireNonNull(img).setBounds(0,0,80,80);
        //the setbounds() throws null pointer exception if there is no image or null value
        //therefore, Objects.requireNonNUll(img) is used to eradicate exception occurance.

        //setBounds(0,0,80,80); here means:
        //L, T is 0, 0, R, B is 80, 80
        //which basically means draw an image from left, top 0, 0 to Right 80, Bottom 80
        //which simplifies to width of 80 and height of 80

        img.setBounds(0,0, img.getIntrinsicWidth(), img.getIntrinsicHeight());
        //here are the two setBounds, which defines as:
        // first setBounds() for specifying the fix size for image.
        //it says image should be drawn within the size of width: 80 and height: 80

        // the second setBounds(): sets the image bounds to actual size of image itself
        txtViewSample.setCompoundDrawables(img, null, img, null);

        //setCompoundDrawables() is a method that allows you to set images around a TextView.
        // You can place images to the left, top, right, or bottom of the text in the TextView

        txtViewSample.setCompoundDrawablePadding(10);
        txtViewSample.setAlpha(1f);  // 1f -> fully opaque 0f- transparent
    }
}