package com.wingsofts.custombehavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//者个demo写的东西还是有些东西的，能让人看到这例子有很多含金量
public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_copy);
//    findViewById(R.id.iv_avatar).setOnClickListener(new View.OnClickListener() {
//      @Override public void onClick(View v) {
//        startActivity(new Intent(MainActivity.this,EasyBehaviorActivity.class));
//      }
//    });
  }


//  public void titleMode(View v){
//    findViewById(R.id.iv_avatar).setVisibility(View.INVISIBLE);
//    findViewById(R.id.tv_title).setVisibility(View.VISIBLE);
//  }
//
//  public void avatarMode(View v ){
//
//    findViewById(R.id.iv_avatar).setVisibility(View.VISIBLE);
//    findViewById(R.id.tv_title).setVisibility(View.INVISIBLE);
//  }
}
