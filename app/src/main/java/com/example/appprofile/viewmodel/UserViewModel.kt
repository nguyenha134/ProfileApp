package com.example.appprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val name = MutableLiveData<String>()

    init {
        name.value ="Ha"
    }

}