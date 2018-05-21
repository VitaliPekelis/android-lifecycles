/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;
import com.example.android.lifecycles.Logger;

public class ChronoActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.logDebug();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The ViewModelStore provides a new ViewModel or one previously created.
        ChronometerViewModel chronometerViewModel
                = ViewModelProviders.of(this).get(ChronometerViewModel.class);

        // Get the chronometer reference
        Chronometer chronometer = findViewById(R.id.chronometer);

        if (chronometerViewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            long startTime = SystemClock.elapsedRealtime();
            Logger.logDebug("start time", startTime+"");
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            Logger.logDebug("start time", chronometerViewModel.getStartTime()+"");
            chronometer.setBase(chronometerViewModel.getStartTime());
        }

        chronometer.start();
    }

    @Override
    protected void onRestart()
    {
        Logger.logDebug();
        super.onRestart();
    }

    @Override
    protected void onStart()
    {
        Logger.logDebug();
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        Logger.logDebug();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        Logger.logDebug();
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        Logger.logDebug();
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        Logger.logDebug();
        super.onDestroy();
    }

    @Override
    public void finish()
    {
        Logger.logDebug();
        super.finish();
    }
}
