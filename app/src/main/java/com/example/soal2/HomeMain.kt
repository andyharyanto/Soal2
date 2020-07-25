package com.example.soal2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home_main.*

class HomeMain : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private val menuData: ArrayList<Menus> = arrayListOf()
    private lateinit var rvMainActivity: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)

        val data = intent.getParcelableExtra(EXTRA_DATA) as UserParcelable
        val tvWelcomeHome: TextView = findViewById(R.id.tvWelcomeName)

        rvMainActivity = findViewById(R.id.rvMainActivity)
        rvMainActivity.hasFixedSize()
        menuData.addAll(DataMenu.menuList)

        tvWelcomeHome.text = data.nama.toString()

        showUserList()
    }

    private fun showUserList() {
        rvMainActivity.layoutManager = GridLayoutManager(this, 3)
        val listMenuAdapter = ListMenuAdapter(menuData)
        rvMainActivity.adapter = listMenuAdapter

        listMenuAdapter.setOnItemClickCallback(object : ListMenuAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Menus) {
                toMenuDetail(data)
            }
        })

    }
    private fun toMenuDetail(menu: Menus) {

        val intent = Intent(this, MenuDetail::class.java)
        intent.putExtra(MenuDetail.EXTRA_MENU_NAME, menu.menuName)
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item != null) {
            setMode(item.itemId)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.btnProfile -> {
                val intentNotification = Intent(this, NotificationActivity::class.java)
                startActivity(intentNotification)
            }

        }
    }


}