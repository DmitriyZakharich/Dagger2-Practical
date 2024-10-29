package com.example.feature.home.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.core.di.CoreComponent
import com.example.feature.home.R
import com.example.feature.home.di.DaggerFeatureComponent
import com.example.feature.home.di.FeatureComponent
import javax.inject.Inject

interface CoreComponentProvider {
    val coreComponent: CoreComponent
}

class FeatureFragment : Fragment(R.layout.fragment_feature) {

    private lateinit var featureComponent: FeatureComponent

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var mainViewModel: FeatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        featureComponent = DaggerFeatureComponent.builder()
            .coreComponent((requireActivity().application as CoreComponentProvider).coreComponent)
            .build()
        featureComponent.inject(this)
        mainViewModel = ViewModelProvider(this, vmFactory)[FeatureViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener{
            mainViewModel.getData()
        }
    }
}
