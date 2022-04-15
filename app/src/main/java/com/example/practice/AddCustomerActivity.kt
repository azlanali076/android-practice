package com.example.practice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.models.Customer
import kotlinx.android.synthetic.main.activity_add_customer.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btnAddCustomer.setOnClickListener(View.OnClickListener {
            val name = txtName.text.toString();
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()
            val phone = txtPhone.text.toString()
            if(name.toString() == "" || email.toString() == "" || password.toString() == "" || phone.toString() == ""){
                Toast.makeText(this,Html.fromHtml("<font color='#000'>All fields are required</font>"),Toast.LENGTH_SHORT).show()
            }else{
                val sharedPref: SharedPreferences = getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE)
                val customersString = sharedPref.getString("customers","[]")
                val customers: ArrayList<Customer> =
                    Gson().fromJson(customersString,object: TypeToken<ArrayList<Customer>>(){}.type)
                val newCustomer = Customer(name,email,password,phone)
                customers.add(newCustomer)
                with (sharedPref.edit()){
                    putString("customers",Gson().toJson(customers))
                    apply()
                }
                Toast.makeText(this,Html.fromHtml("<font color='#000'>Customer Added Successfully!</font>"),Toast.LENGTH_SHORT).show()
            }

        })
    }
}