package com.atn.anhtuankg1997.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.atn.anhtuankg1997.appnhac.Adapter.MainViewPagerAdapter;
import com.atn.anhtuankg1997.appnhac.Fragment.Fragment_Tim_Kiem;
import com.atn.anhtuankg1997.appnhac.Fragment.Fragment_Trang_Chu;
import com.atn.anhtuankg1997.appnhac.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    private  void AnhXa(){
        tabLayout = findViewById(R.id.MyTabLayout);
        viewPager = findViewById(R.id.MyViewPager);
    }

    private void Init(){
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.AddFragment(new Fragment_Trang_Chu(), "Trang Chu");
        mainViewPagerAdapter.AddFragment(new Fragment_Tim_Kiem(), "Tim Kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Init();
    }
}
