package com.cs4520.assignment.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.MVP.CalculatorModel
import com.cs4520.assignment3.MVP.CalculatorModelImpl

class CalculatorViewModel : ViewModel() {
    private val _liveData = MutableLiveData<String>()
    val name : LiveData<String> = _liveData
    private var model: CalculatorModel = CalculatorModelImpl()

    private fun operations(num1: Double?, num2: Double?, operation: (Double, Double) -> Double) {
        if (num1 == null || num2 == null) {
            _liveData.value = "Cannot have Null inputs"
        } else {
            _liveData.value = operation(num1, num2).toString()

        }
    }

    fun add(num1: Double?, num2: Double?) {
        operations(num1, num2, model::add)
    }
    fun subtract(num1: Double?, num2: Double?) {
        operations(num1, num2, model::subtract)

    }

    fun multiply(num1: Double?, num2: Double?) {
        operations(num1, num2, model::multiply)
    }

    fun divide(num1: Double?, num2: Double?) {
        if (num2 == 0.0) {
            _liveData.value = "Cannot divide by 0"
        } else{
            operations(num1,num2, model::divide)
        }
    }

}