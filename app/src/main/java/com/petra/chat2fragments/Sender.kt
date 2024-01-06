package com.petra.chat2fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction


class Sender : Fragment() {
    private lateinit var usernameEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sender, container, false)
        usernameEditText = view.findViewById(R.id.editTextUsername)
        messageEditText = view.findViewById(R.id.editTextMessage)
        //Send Data
        val reciever = Reciever()
        val bundle = Bundle()
        bundle.putString("username",usernameEditText.text.toString())
        bundle.putString("Message",messageEditText.text.toString())
        reciever.arguments=bundle
        sendButton = view.findViewById(R.id.buttonSend)
        sendButton.setOnClickListener {
            val fragmentTransaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_container,reciever).commit()
            sendMessage()
        }

        //Recieve Data
        val data = arguments
        val username:String = data?.getString("username").toString()
        val message:String = data?.getString("Message").toString()

        return view
    }
    private fun sendMessage() {
        val username = usernameEditText.text.toString()
        val message = messageEditText.text.toString()

        if (username.isNotEmpty() && message.isNotEmpty()) {
            val toastMessage = "$username says: $message"
            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_LONG).show()
            // You can send the message to the other fragment or perform any other actions here
        } else {
            Toast.makeText(requireContext(), "Please enter username and message", Toast.LENGTH_SHORT).show()
        }


    }

}