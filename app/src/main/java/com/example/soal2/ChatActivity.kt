package com.example.soal2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val listViewType = mutableListOf<Int>()
        listViewType.add(1)
        listViewType.add(2)
        listViewType.add(1)
        listViewType.add(2)
        val listChat = mutableListOf<Chat>()
        listChat.add(Chat(message = "Hello", dateTime = "12-05-2018 16:36"))
        listChat.add(Chat(message = "Hi", dateTime = "12-05-2018 16:40"))
        listChat.add(Chat(message = "How are you?", dateTime = "12-05-2018 16:41"))
        listChat.add(Chat(message = "I'm fine, Thanks. You?", dateTime = "12-05-2018 16:42"))
        val adapterChat = AdapterChat(listViewType = listViewType, listChat = listChat)
        recycler_view_chat_activity_main.layoutManager = LinearLayoutManager(this)
        recycler_view_chat_activity_main.adapter = adapterChat

    }
}