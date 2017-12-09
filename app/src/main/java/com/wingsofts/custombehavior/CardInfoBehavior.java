package com.wingsofts.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

/**
 * Created by wuzp on 2017/12/3.
 */

public class CardInfoBehavior extends CoordinatorLayout.Behavior<CardView> {

    AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
    public CardInfoBehavior(Context context, AttributeSet attri){
        super(context,attri);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CardView child, View dependency) {
        return dependency instanceof LinearLayout;
    }

    float targetHeight = -1;
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CardView child, View dependency) {
        if(targetHeight == -1){
          targetHeight = dependency.getHeight();
        }
        float percent = dependency.getBottom() / targetHeight;

        if(percent < 0){
            child.setAlpha(0);
        }else{
            child.setAlpha(accelerateInterpolator.getInterpolation(percent));
        }

        Log.e("wzp","percent:" + percent + "\n"
                +" accelerateInterpolator.getInterpolation(percent) "
                + accelerateInterpolator.getInterpolation(percent));
        return true;
    }
}
