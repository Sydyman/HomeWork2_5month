package com.ex.homework2_5month.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ex.homework2_5month.databinding.ActivityLoveBinding
import com.ex.homework2_5month.interfaces.LoveView
import com.ex.homework2_5month.presenter.MainPresenter

class LoveActivity : AppCompatActivity(), LoveView {

    private lateinit var binding: ActivityLoveBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        val firstName = intent.getStringExtra("firstName") ?: ""
        val secondName = intent.getStringExtra("secondName") ?: ""

        if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
            presenter.getPercentage(firstName, secondName)
        }
    }

    override fun showResult(percentage: String, result: String) {
        binding.tvScore.text = result
        binding.tvResult.text = percentage
    }

    override fun showError(message: String) {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
    }
}
