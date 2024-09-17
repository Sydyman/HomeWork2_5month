package com.ex.homework2_5month.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ex.homework2_5month.databinding.ActivityLoveBinding
import com.ex.homework2_5month.interfaces.LoveView
import com.ex.homework2_5month.presenter.MainPresenter

class LoveActivity : AppCompatActivity(), LoveView {

    private lateinit var binding: ActivityLoveBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fname = intent.getStringExtra("fname")
        val sname = intent.getStringExtra("sname")
        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")
        with(binding) {
            tvFirstName.text = fname
            tvSecondName.text = sname
            tvPersantage.text = percentage
            tvResult.text = result


            btnTryAgain.setOnClickListener {
                // Переход обратно на первую Activity
                val intent = Intent(this@LoveActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
