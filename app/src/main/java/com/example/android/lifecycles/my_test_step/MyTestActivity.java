package com.example.android.lifecycles.my_test_step;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.codelabs.lifecycle.R;

public class MyTestActivity extends AppCompatActivity
{

    private TextView mTextMessage;
    private Fragment mOneFragment, mTwoFragment, mThreeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    if(mOneFragment == null) mOneFragment = OneFragment.newInstance();
                    inflateFragment(mOneFragment);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    if(mTwoFragment == null) mTwoFragment = TwoFragment.newInstance();
                    inflateFragment(mTwoFragment);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    if(mThreeFragment == null) mThreeFragment = ThreeFragment.newInstance();
                    inflateFragment(mThreeFragment);
                    return true;
            }
            return false;
        }
    };

    private void inflateFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments_container, fragment)

                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFirstFragment();
    }

    private void initFirstFragment()
    {
        if(mOneFragment == null) mOneFragment = OneFragment.newInstance();
        inflateFragment(mOneFragment);
    }

}
