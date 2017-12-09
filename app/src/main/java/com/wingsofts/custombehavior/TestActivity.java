package com.wingsofts.custombehavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author wuzhenpeng03 (wuzhenpeng03@didichuxing.com)
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}

/***
 *  在appbarlayout中的所以子view都有这样的属性 的滚动参数相对 apptablayout 的滚动来讲的
 *  app:layout_scrollFlags="scroll|enterAlways|enterAlwaysCollapsed|exitUntilCollapsed|snap"
 scroll  必须的属性
 enterAlways 相对进入的参数 每次子view进入滚动 都会涉及到toolbar的进入
 enterAlwaysCollapsed 是enterAlways 的一个附属值，要设置 minHeight使用 ，在效果上先达到最小的高度，在子view滚动完成后 再滚动全部
 exitUntilCollapsed 是对移出动作的描述 就是任何子view的向上滚动，就会导致顶部的滚出到最小高度（最终显示的就是最小高度）
 snap 的效果是 每次滚动 无论是滚进还是滚出，只要没达到阈值，就会回滚动作，只要达到阈值，就会去做完动作（类似viewpager滑动效果一样）
 * */

/**
 * collapsingtoolbarlayout
 *  放在appbarlayout中可以设置 app:layout_scrollFlags = "scroll|enterAlways|enterAlwaysCollapsed|exitUntilCollapsed|contentScrim|expandedTitleMarginStart" 的属性有如下几种：
 * scroll 想要滑动的属性必须设置的值
 * enterAlways 对于进入的设置，只要向下滑动，就能进入
 * enterAlwaysCollapsed 是上边的值的附属值，需要设置minHeight值一块使用，就是先滑动一个最小的值，然后直到子view滑动到顶部，然后再将剩余部分滑出
 * exitUntilCollapsed 这是针对于退出的设置，就是当子view向上滑动时，就滑动至最小值，
 * contentScrim  设置当完全CollapsingToolbarLayout折叠(收缩)后的背景颜色
 * expandedTitleMarginStart  设置扩张时候(还没有收缩时)title向左填充的距离
 *
 * 可以折叠的toolbar  （可以看出和toolbar 的功能一样的，多了折叠的功能）的参数理解
 *
 * 对于collapsingtoolbarlayout 的子view，可以设置折叠的设置：
 *  app:layout_collapseMode="parallax|pin"
 *     parallax 折叠一块动 设置为这个模式时，在内容滚动时，CollapsingToolbarLayout中的View
 *             （比如ImageView)也可以同时滚动，实现视差滚动效果，通常和layout_collapseParallaxMultiplier
 *              (设置视差因子)搭配使用
 *     pin 设置为这个模式时，当CollapsingToolbarLayout完全收缩后，Toolbar还可以保留在屏幕上
 *
 *     app:layout_collapseParallaxMultiplier="0.7" (视差因子) - 设置视差滚动因子，值为：0~1
 *     0表示跟随布局一起滚动 1表示不会滚动，子view滚动时 直接覆盖在上边
 *
 * */

/**
 *  什么是组件 component 是由多个控件组合而成的
 * */