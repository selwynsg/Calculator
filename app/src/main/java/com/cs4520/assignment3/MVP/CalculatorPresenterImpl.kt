package com.cs4520.assignment3.MVP

class CalculatorPresenterImpl(calculatorView: CalculatorView) : CalculatorPresenter {
    private var view: CalculatorView? = calculatorView
    private var model: CalculatorModel = CalculatorModelImpl()

    private fun operations(num1: Double?, num2: Double?, operation: (Double, Double) -> Double) {
        if (num1 == null || num2 == null) {
            view?.printError("The values cannot be null")
        } else {
                val result = operation(num1, num2)
                view?.printAnswer(result.toString())
        }
        view?.clearInput()
    }

    override fun add(num1: Double?, num2: Double?) {
        operations(num1, num2, model::add)
    }
    override fun subtract(num1: Double?, num2: Double?) {
        operations(num1, num2, model::subtract)

    }

    override fun multiply(num1: Double?, num2: Double?) {
        operations(num1, num2, model::multiply)
    }

    override fun divide(num1: Double?, num2: Double?) {
        if (num2 == 0.0) {
            view?.printError("Cannot divide by 0")
            view?.clearInput()
        } else{
            operations(num1,num2, model::divide)
        }
    }

}