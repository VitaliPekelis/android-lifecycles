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
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends BaseFragment
{

    private MyTestViewModel mViewModel;

    public OneFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(/*String param1, String param2*/)
    {
        OneFragment fragment = new OneFragment();
       /* Bundle      args     = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mViewModel = ViewModelProviders.of(getActivity()).get(MyTestViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
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
                if(data == null) return;

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
        mViewModel.addData(1);
    }
}
