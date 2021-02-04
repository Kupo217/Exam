package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        addButton.setOnClickListener {
            add()
        }

        ordersButton.setOnClickListener {
            orders()
        }

        signOutTextView.setOnClickListener {
            exit()
        }
    }

    private fun add(){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    private fun orders(){
        val intent = Intent(this, OrdersActivity::class.java)
        startActivity(intent)
    }

    private fun exit(){
        val intent = Intent(this, AuthenticationActivity::class.java)
        startActivity(intent)
    }
}