package com.example.feature.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.feature.home.domain.usecases.GetData1UseCase
import com.example.feature.home.domain.usecases.GetData2UseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "MyTAG"

class FeatureViewModel @Inject constructor(
    private val getData1UseCase: GetData1UseCase,
    private val getData2UseCase: GetData2UseCase
) : ViewModel() {

    fun getData(){
        viewModelScope.launch {
            val data1 = getData1UseCase.execute()
            Log.d(TAG, "getData: ${data1.string}")
            val data2 =getData2UseCase.execute()
            Log.d(TAG, "getData: ${data2.string}")
        }

    }
}

class MainViewModelFactory @Inject constructor(
    private val getData1UseCase: GetData1UseCase,
    private val getData2UseCase: GetData2UseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FeatureViewModel::class.java)) {
            return FeatureViewModel(getData1UseCase, getData2UseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
