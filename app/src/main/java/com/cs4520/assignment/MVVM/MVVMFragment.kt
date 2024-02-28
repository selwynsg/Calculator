package com.cs4520.assignment.MVVM

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.MvvmFragmentBinding

class MVVMFragment: Fragment(){
    private lateinit var viewModel : CalculatorViewModel
    private var _binding: MvvmFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvvmFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        binding.addBut.setOnClickListener{
            val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
            val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
            viewModel.add(in1, in2)
        }
        binding.subBut.setOnClickListener{
            val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
            val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
            viewModel.subtract(in1, in2)
        }
        binding.multiBut.setOnClickListener{
            val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
            val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
            viewModel.multiply(in1, in2)
        }
        binding.divBut.setOnClickListener {
            val in1 = binding.UserInput1.text.toString().toDoubleOrNull()
            val in2 = binding.UserInput2.text.toString().toDoubleOrNull()
            viewModel.divide(in1, in2)
        }
        this.initObserver()

    }

    private fun initObserver(){
        viewModel.calc.observe(viewLifecycleOwner) { result ->
            binding.Results.text = getString(R.string.results, result)
            binding.Results.visibility = View.VISIBLE
            binding.UserInput1.text.clear()
            binding.UserInput2.text.clear()
        }
        viewModel.err.observe(viewLifecycleOwner) { result ->
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            binding.Results.visibility = View.GONE
            binding.UserInput1.text.clear()
            binding.UserInput2.text.clear()
        }

    }

}