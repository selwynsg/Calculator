package com.cs4520.assignment3.MVP

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.MvpFragmentBinding

class MVPFragment: Fragment(), CalculatorView {
    private lateinit var results: TextView
    private lateinit var num1 : EditText
    private lateinit var num2 : EditText
    private var _binding: MvpFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: CalculatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvpFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        presenter = CalculatorPresenterImpl(this)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        results = binding.Results
        num1 = binding.UserInput1
        num2= binding.UserInput2
        binding.addBut.setOnClickListener{
                val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
                val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
                presenter.add(in1, in2)
            }

        binding.subBut.setOnClickListener{
                val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
                val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
                presenter.subtract(in1, in2)
            }
        binding.multiBut.setOnClickListener{
                val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
                val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
                presenter.multiply(in1, in2)
            }
       binding.divBut.setOnClickListener {
           val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
           val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
           presenter.divide(in1, in2)
       }

    }

    override fun printAnswer(answer: String) {
        results.text = getString(R.string.results,answer)
        results.visibility = View.VISIBLE
    }

    override fun printError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        results.visibility = View.GONE
    }

    override fun clearInput() {
        num1.text.clear()
        num2.text.clear()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()

    }

}