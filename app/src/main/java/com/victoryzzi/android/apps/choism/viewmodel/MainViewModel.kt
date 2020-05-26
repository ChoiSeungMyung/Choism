package com.victoryzzi.android.apps.choism.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.victoryzzi.android.apps.choism.adapter.RepoAdapter
import com.victoryzzi.android.apps.choism.extension.asCallbackFlow
import com.victoryzzi.android.apps.choism.model.GithubOwner
import com.victoryzzi.android.apps.choism.model.GithubRepo
import com.victoryzzi.android.apps.choism.service.NetworkHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class MainViewModel(application: Application) : AndroidViewModel(application) {
    val repoListAdapter = RepoAdapter()

    private val requestOwnerLiveData = MutableLiveData<String>()
    private val requestRepoLiveData = MutableLiveData<String>()

    val responseOwnerLiveData: LiveData<GithubOwner> =
        requestOwnerLiveData.switchMap { query ->
            liveData(Dispatchers.IO) {
                NetworkHelper.ownerService.loadOwner(query).asCallbackFlow()
                    .catch { e ->
                        e.printStackTrace()
                    }.collect {
                        emit(it)
                    }
            }
        }

    //    locationWeatherList에 변화가 생기면 responseLiveDataItem에게 변화를 알려줌
    val responseRepoLiveData: LiveData<List<GithubRepo>> =
        requestRepoLiveData.switchMap {userName ->
            liveData(Dispatchers.IO) {
                NetworkHelper.repoService.loadRepos(userName).asCallbackFlow()
                    .catch {e ->
                        e.printStackTrace()
                    }.collect {
                        emit(it)
                    }
            }
        }

    fun requestOwner(ownerName: String) = requestOwnerLiveData.postValue(ownerName)
    fun requestRepo(ownerName: String) = requestRepoLiveData.postValue(ownerName)
}