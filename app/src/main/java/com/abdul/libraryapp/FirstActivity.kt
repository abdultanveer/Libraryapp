package com.abdul.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    lateinit var bookName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        bookName = findViewById(R.id.etBookName)
    }

    fun handleDb(view: View) {
        Toast.makeText(this,bookName.text.toString(),Toast.LENGTH_SHORT).show()
    }
}