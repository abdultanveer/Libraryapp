package com.abdul.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class BookListActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var booklistView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        booklistView = findViewById(R.id.bookslictview)
        booklistView.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var itemClicked = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,itemClicked,Toast.LENGTH_SHORT).show()
    }
}