package com.example.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.orders_list.view.*



class OrdersAdapter(var ordersListItems: List<Orders>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class OrdersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(orders: Orders){
            itemView.customerNameTextView.text = orders.customerName
            itemView.productTextView.text = orders.product
            itemView.dateTextView.text = orders.date
            itemView.priceTextView.text = orders.price
            itemView.addressTextView.text = orders.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.orders_list, parent, false)
        return OrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OrdersViewHolder).bind(ordersListItems[position])
    }

    override fun getItemCount(): Int {
        return ordersListItems.size
    }

}


