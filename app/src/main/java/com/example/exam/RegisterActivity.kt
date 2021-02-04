package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }

    private fun init(){
        auth = Firebase.auth
        registerButton.setOnClickListener {
            register()
        }
    }

    private fun register(){
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val repeatPassword = repeatPasswordEditText.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()) {
            if (password == repeatPassword) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            d("register", "createUserWithEmail:success")

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            d("register", "createUserWithEmail:failure", task.exception)
                            val report = task.exception
                            Toast.makeText(
                                baseContext, "Authentication failed.$report",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                        // ...
                    }
            }else{
                Toast.makeText(this,"Passwords doesn't match", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }
}