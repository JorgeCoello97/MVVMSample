package com.jorch.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.jorch.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get() //viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.progressVisibility.observe(this, {
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.message.observe(this, { binding.message.text = it })

        with(binding){
            button.setOnClickListener {
                viewModel.onButtonClicked(user = user.text.toString(), password = pass.text.toString())
            }
        }
    }
}