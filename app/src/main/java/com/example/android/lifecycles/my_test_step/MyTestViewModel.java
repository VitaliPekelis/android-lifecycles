package com.example.android.lifecycles.my_test_step;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyTestViewModel extends ViewModel
{
    private MutableLiveData<List<String>> mData = new MutableLiveData<>();

    public MyTestViewModel()
    {
        super();
        List<String> data = mData.getValue();
        if(data==null)
        {
            mData.setValue(new ArrayList<String>());
        }

    }

    public MutableLiveData<List<String>> getData()
    {
        return mData;
    }

    public void addData(int number)
    {
        List<String> list = mData.getValue();
        list.add(number+"");
        mData.setValue(list);
    }
}
