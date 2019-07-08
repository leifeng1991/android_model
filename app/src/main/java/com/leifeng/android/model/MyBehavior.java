package com.leifeng.android.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.cnlive.module.base.utils.LogUtil;
import com.leifeng.base.module.util.PixelUtil;

public class MyBehavior extends CoordinatorLayout.Behavior<View> {
    
    private RecyclerView.OnScrollListener listener;
    private NestedScrollView.OnScrollChangeListener scrollChangeListener;
    
    public MyBehavior() {
    }
    
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        LogUtil.e("=============layoutDependsOn()" + dependency.getY() + "====" + child.getHeight());
        return dependency instanceof ViewPager;
    }
    
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        LogUtil.e("=============onDependentViewChanged()" + dependency.getY() + "====" + child.getHeight());
//        dependency.setTop(PixelUtil.dip2px(dependency.getContext(), 250f));
        return true;
    }
    
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        LogUtil.e("=============onNestedScroll()" + target.getY() + "====" + child.getHeight());
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }
    
    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int type) {
        LogUtil.e("=============onStopNestedScroll()" + target.getY() + "====" + child.getHeight());
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }
    
    
    private int y = 0;
    
    @Override
    public boolean onStartNestedScroll(@NonNull final CoordinatorLayout coordinatorLayout, @NonNull final View child, @NonNull final View directTargetChild, @NonNull final View target, int axes, final int type) {
        boolean b = super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        LogUtil.e("=============onStartNestedScroll()" + target.getY() + "====" + child.getHeight() + "=======" + b + "============" + directTargetChild + "=========" + type);
        if (target instanceof RecyclerView) {
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
                        y += dy;
                        LogUtil.e("=============onScrolled()===" + y);
                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
                        int height = PixelUtil.dip2px(directTargetChild.getContext(), 200f);
                        layoutParams.setMargins(0, y <= 0 ? 0 : y >= height ? -height : -y, 0, 0);
                        child.setLayoutParams(layoutParams);
                        
//                        int i = PixelUtil.dip2px(child.getContext(), 250f);
//                        child.setTop(y <= 0 ? i : y >= i ? 0 : i - y);
                        
                    }
                };
                r.addOnScrollListener(listener);
            }
        } else if (target instanceof NestedScrollView) {
            LogUtil.e("=============onStartNestedScroll()==" + target);
            NestedScrollView ns = (NestedScrollView) target;
            if (scrollChangeListener == null) {
                scrollChangeListener = new NestedScrollView.OnScrollChangeListener() {
                    @Override
                    public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                        LogUtil.e("=============onScrollChange()==" + scrollX + "======" + scrollY + "====" + oldScrollX + "====" + oldScrollY);
                    }
                };
//                ns.onNestedScroll(child,target,ine);
                ns.setOnScrollChangeListener(scrollChangeListener);
            }
        }
        return b;
    }
    
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        LogUtil.e("=============onNestedPreScroll()");
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }
    
    @Override
    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        LogUtil.e("=============onTouchEvent()" + "====" + ev.getAction());
        return super.onTouchEvent(parent, child, ev);
    }
    
    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(parent, child, ev);
        
        LogUtil.e("=============onInterceptTouchEvent()" + parent.getTranslationY() + "====" + parent.getScrollY() + "=====" + b);
        return b;
    }
    
    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {
        
        super.onAttachedToLayoutParams(params);
    }
    
    @Override
    public void onDependentViewRemoved(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        LogUtil.e("=============onDependentViewRemoved()");
        super.onDependentViewRemoved(parent, child, dependency);
    }
    
    @Override
    public boolean onMeasureChild(@NonNull CoordinatorLayout parent, @NonNull View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        LogUtil.e("=============onMeasureChild()");
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }
    
    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        LogUtil.e("=============onLayoutChild()");
        return super.onLayoutChild(parent, child, layoutDirection);
    }
    
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        LogUtil.e("=============onNestedFling()");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
    
    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY) {
        LogUtil.e("=============onNestedPreFling()");
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
}
