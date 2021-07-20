package com.abdul.libraryapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class BookListActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var TAG = BookListActivity::class.java.simpleName
    lateinit var booklistView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        booklistView = findViewById(R.id.bookslictview)
        booklistView.setOnItemClickListener(this)
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

    }

    override fun onStart() {
        super.onStart()

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token: String = task.getResult().toString()

                // Log and toast
                //val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, token)
                Toast.makeText(this, token, Toast.LENGTH_SHORT).show()
            })


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var itemClicked = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,itemClicked,Toast.LENGTH_SHORT).show()
    }
}