package com.wingsofts.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by wuzp on 2017/12/3.
 */
public class LogoBehavior extends CoordinatorLayout.Behavior<ImageView> {

    LinearInterpolator linearInterpolator = new LinearInterpolator();
    DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();

    public LogoBehavior(Context context, AttributeSet attri) {
        super(context, attri);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        //这可以根据任何可以标识的东西来 界定可以依据什么view 来让其他的view来同步这个动作
        return   dependency instanceof LinearLayout;
    }

    float targtHeight = -1;
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
       if(targtHeight == -1){ //the first time to init the var
           targtHeight = dependency.getHeight();//get height  如果使用这个方法获取的是 view的Y值，
           // 那么得到的是这个view 相对父布局的 左上顶点的坐标
       }
        float percent = dependency.getBottom() /  targtHeight;//to get che change and convert to logo icon's alpha
        if(percent < 0){//表示已经滑出屏幕
            child.setAlpha(0);
        }else{//这里可以根据变换的值 来设置icon的透明度
            child.setAlpha( accelerateInterpolator.getInterpolation(percent) );//加速的变换
        }
        //view 's alpha  0 is standard for nothing  1 is standard for every thing
        return true;//貌似这里返回true 对其他的并没有什么影响
    }
}
