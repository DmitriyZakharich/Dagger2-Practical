package com.example.dagger2practicalblock.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core.di.Server1Qualifier
import com.example.core.di.Server2Qualifier
import com.example.feature.home.usecases.GetData1UseCase
import com.example.feature.home.usecases.GetData2UseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getData1UseCase: GetData1UseCase,
    private val getData2UseCase: GetData2UseCase
) : ViewModel() {

    fun getData(){
        viewModelScope.launch {
            val data1 = getData1UseCase.execute()
            Log.d("TAGeeee", "getData: ${data1?.string}")
            val data2 =getData2UseCase.execute()
            Log.d("TAGeeee", "getData: ${data2?.string}")
        }

    }
}

class MainViewModelFactory @Inject constructor(
    private val getData1UseCase: GetData1UseCase,
    private val getData2UseCase: GetData2UseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getData1UseCase, getData2UseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
