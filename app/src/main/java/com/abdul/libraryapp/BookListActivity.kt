package com.abdul.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class BookListActivity : AppCompatActivity(), TextWatcher {
    var TAG = BookListActivity::class.simpleName
    lateinit var searchEdittext: EditText
    lateinit var  booksListview: ListView
    lateinit   var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        var names = arrayOf("ashish","akshay","siddhi","tejas","tom cruise")
        booksListview = findViewById(R.id.booksListview)
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,names)
        booksListview.adapter = adapter
        searchEdittext = findViewById(R.id.etSearch)
        searchEdittext.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }


    override fun onTextChanged(charUserHasTyped: CharSequence?, start: Int, before: Int, count: Int) {
        adapter.filter.filter(charUserHasTyped)
        //i want tostart querying after the user has entered 2 chars
        //if(count >1){
            Log.i(TAG,"user ha entered "+charUserHasTyped)
                //}
    }

    override fun afterTextChanged(s: Editable?) {
    }
}