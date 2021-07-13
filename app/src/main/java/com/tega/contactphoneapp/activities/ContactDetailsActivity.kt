package com.tega.contactphoneapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tega.contactphoneapp.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {

            idDisplayTv.text = intent.getIntExtra("id", 0).toString()
            noteContent.text = intent.getStringExtra("content")
            noteTitle.text = intent.getStringExtra("title")
        }
    }

}