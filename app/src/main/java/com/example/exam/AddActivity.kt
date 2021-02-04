package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        init()
    }

    private fun init(){
        addButton.setOnClickListener {
            if (customerNameEditText.text.toString().isNotEmpty() && productEditText.text.toString()
                    .isNotEmpty() && dateEditText.text.toString()
                    .isNotEmpty() && priceEditText.text.toString().isNotEmpty()
            ) {
                add()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun add() {
        val customerName = customerNameEditText.text.toString()
        val product = productEditText.text.toString()
        val date = dateEditText.text.toString()
        val price = priceEditText.text.toString()
        val address = addressEditText.text.toString()
        val db = FirebaseFirestore.getInstance()

        // Add a new document with a generated id.
        val data = hashMapOf(
            "customerName" to customerName,
            "product" to product,
            "date" to date,
            "price" to price,
            "address" to address
        )


        db.collection("orders")
            .add(data)
            .addOnSuccessListener { documentReference ->
                d("exist", "DocumentSnapshot written with ID: ${documentReference.id}")
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener { e ->
                d("Noexist", "Error adding document", e)
                Toast.makeText(this, "FAILED!!!", Toast.LENGTH_SHORT).show()

            }

    }

}