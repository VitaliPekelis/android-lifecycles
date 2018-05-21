package com.example.android.lifecycles.my_test_step;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.codelabs.lifecycle.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends BaseFragment
{
    private MyTestViewModel mViewModel;

    public TwoFragment()
    {
        // Required empty public constructor
    }


    public static TwoFragment newInstance()
    {
        TwoFragment fragment = new TwoFragment();
        Bundle      args     = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mViewModel = ViewModelProviders.of(getActivity()).get(MyTestViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getData().observe(this, new Observer<List<String>>()
        {
            @Override
            public void onChanged(@Nullable List<String> data)
            {
                //Toast.makeText(getContext(), "onChanged Frag 2 size = " +data.size(), Toast.LENGTH_SHORT).show();

                textView.setText("");
                //Toast.makeText(getContext(), "onChanged Frag 1 size = " +data.size(), Toast.LENGTH_SHORT).show();
                StringBuilder string = new StringBuilder();

                for (String item : data)
                {
                    string.append(item).append("\n");
                }

                textView.setText(string);
            }
        });
    }


    //------------------
    // BaseFragment - implementation
    //------------------
    @Override
    void addData()
    {
        mViewModel.addData(2);
    }
}
