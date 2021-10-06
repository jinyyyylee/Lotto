package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

 /*   val editname: EditText = findViewById(R.id.editname)
    val editemail: EditText = findViewById(R.id.editemail)
    val editpwd: EditText = findViewById(R.id.editpwd)
    val editphone: EditText = findViewById(R.id.editphone)
    val registerbt: Button = findViewById(R.id.registerbt)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerbt.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        val email: String = editemail.text.toString().trim()
        val pwd: String = editpwd.text.toString().trim()
        val name: String = editname.text.toString().trim()
        val phone: String = editphone.text.toString().trim()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "email을 입력해주세요", Toast.LENGTH_LONG).show()
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "password를 입력해주세요", Toast.LENGTH_LONG).show()
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "name을 입력해주세요", Toast.LENGTH_LONG).show()
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone number을을 입력해주세요", Toast.LENGTH_LONG).show()
        }

        auth?.createUserWithEmailAndPassword(email, pwd)?.addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val user = auth?.currentUser
            } else {
            }
        }
    }


}
