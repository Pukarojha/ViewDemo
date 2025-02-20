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

    Context context;

public CustomTouchListener(Context context){
    this.context = context;
    gestureDetector = new GestureDetector(context, new CustomGestureListener(context));
}
    //this is needed to create gestureDetector
    public class CustomGestureListener extends
            GestureDetector.SimpleOnGestureListener{


    Context context;


        public CustomGestureListener(Context context) {
            this.context = context;
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            super.onLongPress(e);
            onLongClick();
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            float SWIPE_DIST_THRESHOLD = 10;
            float SWIPE_VEL_THRESHOLD =20;

            float XOff = e2.getX() -e1.getX();
            float YOff = e2.getY() -e1.getY();

            if(Math.abs(XOff > YOff)
            && Math.abs(XOff) > SWIPE_DIST_THRESHOLD
                    && Math.abs(velocityX) > SWIPE_VEL_THRESHOLD
            ){
                //horizontal swipe
                if(XOff > 0){
                    onRightSwipe();
                }else{
                    onLeftSwipe();
                }

            }else if(Math.abs(YOff > XOff)
                    && Math.abs(YOff) > SWIPE_DIST_THRESHOLD
                    && Math.abs(velocityY) > SWIPE_VEL_THRESHOLD
            ) {
                //vertical swipe
                if (YOff > 0) {
                    onDownSwipe();
                } else {
                    onUpSwipe();
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDown(@NonNull MotionEvent e) {


            return true;
//            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            onSingleClick();
            return super.onSingleTapConfirmed(e);
        }
    }

    public void onUpSwipe() {
        Log.d("GESTURE DEMO", "UP swipe detected");
    }

    public void onDownSwipe() {
        Log.d("GESTURE DEMO", "Down Swipe Detected");
    }

    public void onRightSwipe() {
        Log.d("GESTURE DEMO", "Right Swipe Detected");
    }

    public void onLeftSwipe() {
        Log.d("GESTURE DEMO", "Left Swipe Detected");
    }

    public void onDoubleClick() {
        Log.d("GESTURE DEMO", "Double Click Detected!");
    }

    public void onSingleClick() {
        Log.d("GESTURE DEMO", "Single Click detected.");
    }

    public void onLongClick() {
         Log.d("Gesture Detected", "Long Click detected");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
//        return false;

    }
}
