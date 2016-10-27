package com.example.luissancar.ejemploviewpager;

import android.support.annotation.ColorRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/*

https://amatellanes.wordpress.com/2013/05/25/android-ejemplo-de-viewpager-en-android-parte-1/
 */
public class MainActivity extends FragmentActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally
     * to access previous and next pages.
     */
    ViewPager pager = null;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.main);

        // Instantiate a ViewPager
        this.pager = (ViewPager) this.findViewById(R.id.pager);

        // Create an adapter with the fragments we show on the ViewPager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
        adapter.addFragment(ScreenSlidePageFragment.newInstance(R.color.color1, 1));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(R.color.color2, 2));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(R.color.color3, 3));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(R.color.color4, 4));
        this.pager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {

        // Return to previous page when we press back button
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

    }

}
