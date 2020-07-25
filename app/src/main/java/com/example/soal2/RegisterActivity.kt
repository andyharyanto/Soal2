package com.example.soal2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener, DatePickerFragment.DialogDateListener {

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
    }

    private var dateFinal: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnTanggalLahir.setOnClickListener(this)
        btnSimpan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnTanggalLahir -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)
            }

            R.id.btnSimpan -> {
                val nama = etNama.text.toString()
                val alamat = etAlamat.text.toString()
                val email = etEmail.text.toString()

                val data = UserParcelable(
                    nama,
                    alamat,
                    email
                )

                val intent2 = Intent(this, HomeMain::class.java)
                intent2.putExtra(HomeMain.EXTRA_DATA, data)
                startActivity(intent2)
                finish()
            }
        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        dateFinal = dateFormat.format(calendar.time)
        tvTanggalLahir.setText(dateFinal)
    }
}