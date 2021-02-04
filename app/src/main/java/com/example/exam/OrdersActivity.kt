package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_orders.*

class OrdersActivity : AppCompatActivity() {

    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var ordersList: List<Orders> = ArrayList()
    private val ordersAdapter: OrdersAdapter = OrdersAdapter(ordersList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        init()
    }

    private fun init(){
        loadOrdersData()
        rvOrders.layoutManager = LinearLayoutManager(this)
        rvOrders.adapter = ordersAdapter
    }



    private fun loadOrdersData(){
        firebaseRepo.getOrdersList().addOnCompleteListener {
            if(it.isSuccessful){
                ordersList = it.result!!.toObjects(Orders::class.java)
                ordersAdapter.ordersListItems = ordersList
                ordersAdapter.notifyDataSetChanged()
            }
        }
    }

}