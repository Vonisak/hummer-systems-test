package com.vonisak.dodo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vonisak.dodo.R
import com.vonisak.dodo.presentation.viewmodel.PizzeriaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}