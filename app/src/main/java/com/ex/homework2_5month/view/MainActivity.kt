// MainActivity.kt
package com.ex.homework2_5month.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ex.homework2_5month.R
import com.ex.homework2_5month.databinding.ActivityMainBinding
import com.ex.homework2_5month.interfaces.LoveView
import com.ex.homework2_5month.presenter.MainPresenter

class MainActivity : AppCompatActivity(), LoveView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btnNext.setOnClickListener {

                presenter.getPercentage(binding.etFirst.text.toString(), binding.etSecond.text.toString())


                val intent = Intent(this, LoveActivity::class.java).apply {
                    putExtra("firstName", binding.etFirst.text.toString())
                    putExtra("secondName", binding.etSecond.text.toString())
                }
                startActivity(intent)

            }
        }

    override fun showResult(percentage: String, result: String) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }
}




