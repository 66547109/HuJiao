package com.hujiao.hujiao;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.hujiao.hujiao.util.T;
import com.hujiao.hujiao.view.*;

public class MainActivity extends Activity implements View.OnClickListener {
    private SlideMenu slideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initSlideMenu();
    }

    private void initSlideMenu() {
        slideMenu = (SlideMenu) findViewById(R.id.slide_menu);
        ImageView menuImg = (ImageView) findViewById(R.id.title_bar_menu_btn);
        menuImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_bar_menu_btn:
                if (slideMenu.isMainScreenShowing()) {
                    slideMenu.openMenu();
                } else {
                    slideMenu.closeMenu();
                }
                break;
        }
    }

    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.rel_head:
                T.s("头像");
                break;
            case R.id.tv_photo:
                T.s("相册");
                break;
            case R.id.tv_setting:
                T.s("设置");
                break;
        }
    }

}
