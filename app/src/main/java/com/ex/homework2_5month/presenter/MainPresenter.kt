// MainPresenter.kt
package com.ex.homework2_5month.presenter

import android.content.Context
import com.ex.homework2_5month.app.RetrofitService
import com.ex.homework2_5month.models.LoveModel
import com.ex.homework2_5month.interfaces.LoveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: LoveView) {

    private val api = RetrofitService.api

    fun getPercentage(firstName: String, secondName: String) {
        api.getPercentage(
            key = "31f3b10fcdmshd451fcf9c1dff16p11c153jsn61318108bd9b",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        view.showResult(result.percentage, result.result)
                    } else {
                        view.showError("Нет данных")
                    }
                } else {
                    view.showError("Ошибка сервера")
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError("Ошибка сети")
            }
        })
    }
}
