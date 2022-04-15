package com.example.practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.models.Customer
import kotlinx.android.synthetic.main.list_customers.view.*

class CustomerAdapter(val customers: ArrayList<Customer>): RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {
    class CustomerViewHolder(viewHolder: View): RecyclerView.ViewHolder(viewHolder)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomerViewHolder {
        return CustomerViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.list_customers,p0,false)
        )
    }

    override fun onBindViewHolder(p0: CustomerViewHolder, p1: Int) {
        val currentCustomer = customers[p1];
        p0.itemView.apply {
            p0.itemView.cusName.text = currentCustomer.name;
            p0.itemView.cusEmail.text = currentCustomer.email;
            p0.itemView.cusPhone.text = currentCustomer.phone;
        }
    }

    fun addItem(customer: Customer){
        customers.add(customer)
        this.notifyItemInserted(customers.size-1);
    }

    override fun getItemCount(): Int {
        return customers.size;
    };


}