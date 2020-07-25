package com.example.soal2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_detail.*

class MenuDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_MENU_NAME = "extra_menu_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)


        val menuDetailName = intent.getStringExtra(EXTRA_MENU_NAME)
        val text = "Menu Name : $menuDetailName"
        tvMenuDetailName.text = text

    }
}