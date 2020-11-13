package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    private var num: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numbreClick(view: View){
        if(view is TextView) {
            var result: String = resultTextView.text.toString()
            var number: String = view.text.toString()
            if(result == "0"){
                result = ""
            }
            if(view.text.toString() == "."){
                if(resultTextView.text.toString().indexOf(".") >= 0){
                        number = ""
                    }

            }
            resultTextView.text = result + number
        }
    }

    fun operationClick(view: View){
        if(view is TextView){
            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }
            operation = view.text.toString()
            resultTextView.text = ""

        }
    }

    fun equalsClick(view: View){
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0
        if(!TextUtils.isEmpty(secOperandText)){
            secOperand = secOperandText.toDouble()
        }
        when(operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()

        }

    }

    fun clearClick(view: View){
        resultTextView.text = ""
    }

    fun delClick(view: View){
        resultTextView.text = resultTextView.text.dropLast(1)
    }

    fun kacitadze(view: View){
        resultTextView.text = ""
        if(num%2 == 0){
            resultTextView.text = "ბედნიერადაა საქმე"
        }else{
            resultTextView.text = "ლექცია გამიზიარეთ"
        }
        num += 1
    }
}

