package com.example.viewdemo;
import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomTouchListener  implements View.OnTouchListener{

    GestureDetector gestureDetector;
    //gestureDetector needs custom and simpleOnGestureListener


    //this is needed to create gestureDetector
    public class CustomGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        Context context;

        public CustomGestureListener(Context context) {
            this.context = context;
            gestureDetector = new GestureDetector(context, new CustomGestureListener());
        }

        public CustomGestureListener() {

        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDown(@NonNull MotionEvent e) {


            return true;
//            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            onLongClick();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }
    }

    public void onLongClick() {
         Log.d("Gesture Detected", "Long Click deteteced");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
//        return false;

    }
}
