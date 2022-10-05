package com.rak_developer.kotlinpracticeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rak_developer.kotlinpracticeapp.R

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val txtLogin = view.findViewById<TextView>(R.id.txtLogin)
        txtLogin?.setOnClickListener {
//            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return view
    }

}