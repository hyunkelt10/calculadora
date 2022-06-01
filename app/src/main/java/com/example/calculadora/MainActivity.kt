package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var n1 = 0
    private var n2 = 0
    private var op = NO_OP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.pantalla.text = "0"
        b.button0.setOnClickListener { pressNum("0") }
        b.button1.setOnClickListener { pressNum("1") }
        b.button2.setOnClickListener { pressNum("2") }
        b.button3.setOnClickListener { pressNum("3") }
        b.button4.setOnClickListener { pressNum("4") }
        b.button5.setOnClickListener { pressNum("5") }
        b.button6.setOnClickListener { pressNum("6") }
        b.button7.setOnClickListener { pressNum("7") }
        b.button8.setOnClickListener { pressNum("8") }
        b.button9.setOnClickListener { pressNum("9") }
        b.buttonpunto.setOnClickListener { }

        b.opDiv.setOnClickListener {
            n1 = b.pantalla.text.toString().toInt()
            op = 4
            b.pantalla.text = "0"



        }
        b.opMult.setOnClickListener {
            n1 = b.pantalla.text.toString().toInt()
            op = 3
            b.pantalla.text = "0"

        }
        b.opRest.setOnClickListener {
            n1 = b.pantalla.text.toString().toInt()
            op = 2
            b.pantalla.text = "0"

        }
        b.opSum.setOnClickListener {
            n1 = b.pantalla.text.toString().toInt()
            op = 1
            b.pantalla.text = "0"

        }



        b.opIgual.setOnClickListener {
            n2 = b.pantalla.text.toString().toInt()
            var result = when (op) {
                1 -> n1 + n2
                2 -> n1 - n2
                3 -> n1 * n2
                4 -> n1 / n2
                else -> 0
            }
            b.pantalla.text = result.toString()
        }
        b.buttonclear.setOnClickListener { b.pantalla.text ="0".toInt().toString() }



    }
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OP = 0

    }
    fun pressNum(n:String) {
        if (b.pantalla.text.length < 9)
        b.pantalla.text = b.pantalla.text.toString().plus(n).toInt().toString()
    }






}