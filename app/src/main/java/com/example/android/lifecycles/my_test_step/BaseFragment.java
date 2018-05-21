package com.example.android.lifecycles.my_test_step;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.android.codelabs.lifecycle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment
{
    protected TextView textView;

    public BaseFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addData();
            }
        });

        textView = view.findViewById(R.id.text);
    }

    abstract void addData();
}
