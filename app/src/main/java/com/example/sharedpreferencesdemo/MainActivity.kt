package com.example.sharedpreferencesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.sharedpreferencesdemo.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var btShowUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindControls()
        events()

        //handle save user to core application
        CoreApplication.instance.saveUser(User("id101", "tahn", "19"))
    }

    private fun bindControls(){
        btShowUser = findViewById(R.id.bt_show_user)
    }

    private fun events(){
        btShowUser.setOnClickListener {
            Toast.makeText(this@MainActivity, CoreApplication.instance.geUser().toString(), Toast.LENGTH_LONG).show()
        }
    }
}
