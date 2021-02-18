package com.junit.poc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.junit.poc.databinding.ActivityMainBinding
import com.junit.poc.feature.main.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val userViewModel: UserViewModel by viewModel()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.userViewModel = userViewModel

        userViewModel.getUserInfo().observe(this,{
            it.onSuccess {
                    Log.e("Success",""+it.toString())
            }
            it.onFailure {
                Log.e("Failure",""+it.toString())
            }
        })

    }
}