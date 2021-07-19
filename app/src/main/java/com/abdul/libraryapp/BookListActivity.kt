package com.abdul.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class BookListActivity : AppCompatActivity(), TextWatcher, AdapterView.OnItemClickListener {
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
        booksListview.setOnItemClickListener(this)
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

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var itemClicked = parent?.getItemAtPosition(position).toString()

        var alertDialogBuilder = AlertDialog.Builder(this)
            .setTitle(itemClicked)
        alertDialogBuilder.show()
    }
}