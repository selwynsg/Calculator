package com.cs4520.assignment3.MVP

interface CalculatorView {
    fun printAnswer(answer : String);
    fun printError(error : String);
    fun clearInput();

}