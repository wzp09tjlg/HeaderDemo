package com.wingsofts.custombehavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.wingsofts.custombehavior.adapter.DishAdapter;

/**
 * @author wuzhenpeng03 (wuzhenpeng03@didichuxing.com)
 *
 * 参看效果图  计划将商铺首页的动效部分拆分成四个部分
 * 1顶部的toolbar
 * 2logoIcon
 * 3card信息页
 * 4menu页
 */
public class HeaderTestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_header);
    }

    /**
     * 1.最简单的card页的实现
     * */
}
