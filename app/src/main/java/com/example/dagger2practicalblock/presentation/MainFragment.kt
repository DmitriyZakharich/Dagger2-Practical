package com.example.dagger2practicalblock.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2practicalblock.MyApp
import com.example.dagger2practicalblock.R
import javax.inject.Inject


class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as? MyApp)?.appComponent?.inject(this)
        mainViewModel = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener{
            mainViewModel.getData()
        }
    }
}
