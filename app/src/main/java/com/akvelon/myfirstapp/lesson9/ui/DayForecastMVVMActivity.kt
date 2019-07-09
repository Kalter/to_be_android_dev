package com.akvelon.myfirstapp.lesson9.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.akvelon.myfirstapp.R

class DayForecastMVVMActivity : AppCompatActivity() {
    private lateinit var dayInfoView: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var dayForecastViewModel: DayForecastMVVMViewModel

    companion object {
        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, DayForecastMVVMActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.ac_mvp_day_forecast)

        dayForecastViewModel = ViewModelProviders.of(this).get(DayForecastMVVMViewModel::class.java)

        dayInfoView = findViewById(R.id.tvDayForecast)
        progressBar = findViewById(R.id.progressBar)
        findViewById<View>(R.id.btnLoadWithRxJava).setOnClickListener { dayForecastViewModel.fetchKazanWeather() }

        dayForecastViewModel.temperatureInfo.observe(this, Observer {
            showTemperatureInCelsius(it)
        })
        dayForecastViewModel.dataLoading.observe(this, Observer {
            if (it) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun showTemperatureInCelsius(temperatureInCelsius: Float) {
        dayInfoView.text = getString(R.string.temp_celsius_pattern, temperatureInCelsius)
    }
}