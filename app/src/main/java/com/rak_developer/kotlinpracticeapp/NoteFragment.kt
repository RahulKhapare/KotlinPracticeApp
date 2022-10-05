package com.rak_developer.kotlinpracticeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.rak_developer.kotlinpracticeapp.R

class NoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note, container, false)

        val txtNote = view.findViewById<TextView>(R.id.txtNote)
        txtNote?.setOnClickListener {
//            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return view
    }

}