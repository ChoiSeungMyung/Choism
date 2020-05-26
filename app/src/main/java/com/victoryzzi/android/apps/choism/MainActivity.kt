package com.victoryzzi.android.apps.choism

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.victoryzzi.android.apps.choism.databinding.ActivityMainBinding
import com.victoryzzi.android.apps.choism.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        intent.data?.let {
            intent.dataString?.let { userName ->
                mainViewModel.apply {
                    requestOwner(userName)
                    requestRepo(userName)

                    responseOwnerLiveData.observe(this@MainActivity, Observer {
                        binding.owner = it
                    })

                    responseRepoLiveData.observe(this@MainActivity, Observer {
                        repoListAdapter.submitList(it)
                    })
                }
            }
        }
    }
}
