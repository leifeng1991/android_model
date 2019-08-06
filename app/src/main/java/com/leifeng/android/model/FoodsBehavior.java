package com.leifeng.android.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.cnlive.module.base.utils.LogUtil;
import com.leifeng.base.module.util.PixelUtil;

public class FoodsBehavior extends AppBarLayout.Behavior {
    /**
     * 是否处于惯性滑动状态
     */
    private boolean isFlinging = false;
    private RecyclerView.OnScrollListener listener;
    
    public FoodsBehavior() {
    }
    
    public FoodsBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
        LogUtil.e("==============onStopNestedScroll===" + target);
        //如果不是惯性滑动,让他可以执行紧贴操作
        if (!isFlinging) {
            super.onStopNestedScroll(coordinatorLayout, abl, target, type);
        }
    }
    
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        if (target instanceof RecyclerView) {
            CoordinatorLayout.LayoutParams l = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            l.setMargins(0,PixelUtil.dip2px(child.getContext(),200f),0,0);
            child.setLayoutParams(l);
            RecyclerView r = (RecyclerView) target;
            if (listener == null) {
                listener = new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        LogUtil.e("=============onScrollStateChanged()");
                        super.onScrollStateChanged(recyclerView, newState);
                    }
                    
                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        LogUtil.e("=============onScrollStateChanged()");
                        
                    }
                };
                r.addOnScrollListener(listener);
            }
            LogUtil.e("==============onNestedPreScroll===" + target + "=====" + child);
            //type==1时处于非惯性滑动
            if (type == 1) {
                isFlinging = false;
            }
        }
    }
    
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        LogUtil.e("==============onNestedFling===" + target + "====" + child);
        //惯性滑动的时候设置为true
        isFlinging = true;
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
