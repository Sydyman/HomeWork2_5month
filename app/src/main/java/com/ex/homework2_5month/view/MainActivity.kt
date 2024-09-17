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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnGetLove.setOnClickListener {
                RetrofitService.api.getLove(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                val fname = response.body()?.fname
                                val sname = response.body()?.sname
                                val percentage = response.body()?.percentage
                                val result = response.body()?.result

                                // Создаем Intent для перехода в новую Activity
                                val intent = Intent(requireContext(), SecondActivity::class.java).apply {
                                    putExtra("fname", fname)
                                    putExtra("sname", sname)
                                    putExtra("percentage", percentage)
                                    putExtra("result", result)
                                }

                                // Запускаем SecondActivity
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure:${t.message}")
                        }

                    })
            }
        }
    }
}




