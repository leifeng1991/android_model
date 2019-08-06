package com.leifeng.android.model;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

import com.cnlive.module.base.utils.ToastManager;

public class MyImageView extends AppCompatImageView {
    
    public MyImageView(Context context) {
        super(context);
    }
    
    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    private float tempX;
    private float tempY;
    private float moveX;
    private float moveY;
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float scrollX = event.getX();
        float scrollY = event.getY();
        
        int action = event.getAction();
        if (MotionEvent.ACTION_DOWN == action){
            tempX = scrollX;
            tempY= scrollY;
        }else if (MotionEvent.ACTION_MOVE == action){
            moveX = scrollX;
            moveY= scrollY;
        }else if (MotionEvent.ACTION_UP == action){
            if (Math.abs(moveX - tempX) > 0 || Math.abs(moveY - tempY) > 0){
                Toast.makeText(getContext(),"滑动",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(),"点击",Toast.LENGTH_SHORT).show();
            }
            tempX = 0;
            tempY = 0;
            moveX = 0;
            moveY = 0;
        }else if (MotionEvent.ACTION_CANCEL == action){
            if (Math.abs(moveX - tempX) > 0 || Math.abs(moveY - tempY) > 0){
                Toast.makeText(getContext(),"滑动",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(),"点击",Toast.LENGTH_SHORT).show();
            }
            tempX = 0;
            tempY = 0;
            moveX = 0;
            moveY = 0;
        }
        return true;
    }
    
}
