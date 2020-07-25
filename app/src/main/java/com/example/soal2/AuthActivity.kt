package com.example.soal2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                view_timer.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                view_timer.setText("done!")
            }
        }.start()

        tvUbahHp.setOnClickListener(this)
        btnConfirm.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvUbahHp -> {
                Toast.makeText(this, "Tara!!!", Toast.LENGTH_SHORT).show()
            }

            R.id.btnConfirm -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}