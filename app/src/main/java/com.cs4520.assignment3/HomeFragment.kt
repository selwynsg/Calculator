package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cs4520.assignment3.databinding.HomeFragmentBinding

class HomeFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mvpButton = view.findViewById<Button>(R.id.MVP)
        mvpButton.apply {
            setOnClickListener {
                    findNavController().navigate(R.id.to_MVPFragment)
            }
        }
        val mvvmButton = view.findViewById<Button>(R.id.MVVM)
        mvvmButton.apply {
            setOnClickListener {
                findNavController().navigate(R.id.to_MVVMFragment)
            }
        }
    }

}