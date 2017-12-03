package com.wingsofts.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

/**
 * Created by wuzp on 2017/12/3.
 */
public class ToolbarBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    LinearInterpolator linearInterpolator = new LinearInterpolator();///感觉顶部的动画效果是线性的关系

    public ToolbarBehavior(Context context, AttributeSet attri){
        super(context,attri);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency instanceof LinearLayout;
    }

    float startHeight = -1;
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {
        if(startHeight == -1){
            startHeight = dependency.getHeight();
        }
        float percent = dependency.getBottom() / startHeight;

        if(percent < 0){
            child.setAlpha(0);
        }else{
            child.setAlpha(linearInterpolator.getInterpolation(percent));
        }
        return true;
    }
}
