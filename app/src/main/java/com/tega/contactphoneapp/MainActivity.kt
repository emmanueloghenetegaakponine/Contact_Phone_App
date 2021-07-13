package com.tega.contactphoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.tega.contactphoneapp.activities.ContactDetailsActivity
import com.tega.contactphoneapp.databinding.ActivityMainBinding
import com.tega.contactphoneapp.models.Contact
import com.tega.contactphoneapp.models.ContactAdapter
import com.tega.contactphoneapp.models.ContactDatabase
import com.tega.contactphoneapp.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: ContactDatabase
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact_database"
        ).allowMainThreadQueries().build()

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getNotes(database)

        contactAdapter = ContactAdapter(listOf<Contact>()) {
            val intent = Intent(this@MainActivity, ContactDetailsActivity::class.java)
            intent.run {
                putExtra("id", it.id)
                putExtra("content", it.content)
                putExtra("title", it.title)
            }
            startActivity(intent)
        }
        binding.notesRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contactAdapter
        }

        viewModel.notesLiveData.observe(this, { notes ->
            contactAdapter.contacts = notes
            contactAdapter.notifyDataSetChanged()
        })


        binding.saveButton.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val content = binding.contentInput.text.toString()

            saveNote(title, content)
        }

    }

    private fun saveNote(title: String, content: String) {
        val contact = Contact(id = 1, title, content)
        viewModel.addNote(database, contact)
    }
}