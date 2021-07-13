package com.tega.contactphoneapp.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tega.contactphoneapp.databinding.ContactItemBinding
import com.tega.contactphoneapp.models.ContactAdapter.*

class ContactAdapter(var contacts: List<Contact>, val clicker: (Contact)-> Unit) : RecyclerView.Adapter<NoteViewHolder>(){

    inner class NoteViewHolder(private val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindNote(contact: Contact) {
            binding.apply {
                idDisplay.text = contact.id.toString()
                titleDisplay.text = contact.title
                root.setOnClickListener { clicker(contact) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int): NoteViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindNote(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}

