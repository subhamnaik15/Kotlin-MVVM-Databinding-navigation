package com.minjee.basicmvvmexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/*
 *      MainViewModel
 *      - viewModel that updates the MainFragment (the visible UI)
 *      - gets the data from model
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {


    // When this data changes, it triggers the UI to do an update
    val uiTextLiveData = MutableLiveData<String>()

    // Set data
    fun setDataInTextView(result : String?){
        uiTextLiveData.postValue(result)
    }
    // update data
    fun updateDataInTextView(){
        uiTextLiveData.postValue("Screen : Fragment 2")
    }

    var userName = MutableLiveData("Default Text")
    var password = MutableLiveData(0)

}