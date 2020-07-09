package com.yoloyoj.hse_homework1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoloyoj.hse_homework1.filter_recycler_adapter.models.FilterItem

class MainViewModel : ViewModel() {
    var filterItems = MutableLiveData<List<FilterItem>>()
}
