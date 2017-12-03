package com.wingsofts.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by wuzp on 2017/12/4.
 */
public class HeaderBehavior extends CoordinatorLayout.Behavior<FrameLayout> {
    LinearInterpolator interpolator = new LinearInterpolator();

    public HeaderBehavior(Context context, AttributeSet attri){
        super(context,attri);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FrameLayout child, View dependency) {
        return dependency instanceof LinearLayout;
    }

    float startHeight = -1;
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FrameLayout child, View dependency) {
      if(startHeight == -1){
          startHeight = dependency.getHeight();
      }
      float percent = dependency.getBottom() / startHeight;

      if(percent < 0){
          child.setAlpha(1);
      }else{
          child.setAlpha(interpolator.getInterpolation(1-percent));
      }
        return true;
    }
}
