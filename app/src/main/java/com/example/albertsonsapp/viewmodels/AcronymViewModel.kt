package com.example.albertsonsapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.albertsonsapp.R
import com.example.albertsonsapp.model.Lf
import com.example.albertsonsapp.remote.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AcronymViewModel(private val app: Application) : AndroidViewModel(app) {
    private val _lfList = MutableLiveData<List<Lf>>()
    val lfList: LiveData<List<Lf>>
        get() = _lfList
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun getAcronym(acronym: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Repo.getAcronym(acronym)?.firstOrNull()?.let { _lfList.postValue(it.lfs) }
                    ?: _error.postValue(app.getString(R.string.error_msg))
        }
    }

}