package com.example.practice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.adapter.CustomerAdapter
import com.example.practice.models.Customer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val customers: ArrayList<Customer> = ArrayList();
//        customers.add(Customer("Abc","abc@gmail.com","admin123","+11231231234"))
//        customers.add(Customer("Def","def@gmail.com","admin123","+11231231234"))
//        customers.add(Customer("Ghi","ghi@gmail.com","admin123","+11231231234"))

        val sharedPref: SharedPreferences = getSharedPreferences("MY_SHARED_PREF",Context.MODE_PRIVATE)

        val customersString = sharedPref.getString("customers","[]");

        val gson = Gson()

        val type = object: TypeToken<ArrayList<Customer>>() {}.type
        val customers: ArrayList<Customer> = gson.fromJson(customersString,type);

        if(customers.size == 0){
            customers.add(Customer("Azlan","azlan@gmail.com","admin123","12312312345"));
            val newCustomersString = gson.toJson(customers);
            with (sharedPref.edit()) {
                putString("customers",newCustomersString)
                apply()
            }
        }

//        Toast.makeText(this,customersString,Toast.LENGTH_SHORT).show()

        val customersAdapter = CustomerAdapter(customers);

        rView.adapter = customersAdapter
        rView.layoutManager = LinearLayoutManager(this)

        val addCustomerBtn = findViewById<Button>(R.id.addCustomerBtn)
        addCustomerBtn.setOnClickListener(View.OnClickListener {
            val addCustomerIntent = Intent(this,AddCustomerActivity::class.java);
            startActivity(addCustomerIntent)
        })
    }
}