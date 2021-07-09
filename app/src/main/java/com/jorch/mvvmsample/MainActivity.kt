package com.jorch.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.jorch.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainPresenter.MainView {
    private lateinit var binding: ActivityMainBinding
    private val mainPresenter by lazy { MainPresenter(this, lifecycleScope) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope
        with(binding){
            button.setOnClickListener {
                mainPresenter.onButtonClicked(user = user.text.toString(), password = pass.text.toString())
            }
        }
    }

    override fun setProgressVisible(visible: Boolean) {
        binding.progress.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun setMessage(message: String) {
        binding.message.text = message
    }
}