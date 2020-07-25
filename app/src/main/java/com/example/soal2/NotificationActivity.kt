package com.example.soal2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_notification.*
import org.json.JSONArray
import java.lang.Exception

class NotificationActivity : AppCompatActivity() {

    companion object{
        private val TAG = NotificationActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        getListData()
    }

    private fun getListData(){
        progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://programming-quotes-api.herokuapp.com/quotes/page/1"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                progressBar.visibility = View.INVISIBLE

                val listQuote = ArrayList<String>()

                val result = responseBody?.let { String(it) }
                Log.d(TAG, result!!)

                try {
                    val jsonArray = JSONArray(result)

                    for(i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        val quote = jsonObject.getString("en")
                        val author = jsonObject.getString("author")
                        listQuote.add("\n$quote\n - $author\n")
                    }
                    val adapter = ArrayAdapter(this@NotificationActivity, android.R.layout.simple_list_item_1, listQuote)
                    listQuotes.adapter = adapter

                    listQuotes.setOnItemClickListener { parent, view, position, id ->
                        val element = parent.getItemAtPosition(position) as String // The item that was clicked
                        val intent = Intent(this@NotificationActivity, ChatActivity::class.java)
                        startActivity(intent)
                    }

                }
                catch (e: Exception){
                    Toast.makeText(this@NotificationActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                progressBar.visibility = View.INVISIBLE

                val errorMessage = when(statusCode){
                    401 -> "$statusCode: Bad Request"
                    403 -> "$statusCode: Forbidden"
                    404 -> "$statusCode: Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@NotificationActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}