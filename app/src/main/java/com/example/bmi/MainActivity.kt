package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    var lastNUmeric:Boolean = false
    var lastDot:Boolean=false


    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        lastNUmeric = true
        lastDot = false}


    fun onClear(view: View) {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNUmeric && !lastDot) {


            tvInput?.append(".")
            lastNUmeric = false
            lastDot = true

        }}



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
        supportActionBar?.hide()



            var button = findViewById<Button>(R.id.button)
            button.setOnClickListener(){

                var tvValue = tvInput?.text.toString()

                if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    var heightinm:Double = (two.toDouble()/100)
                    var height3:Double = heightinm*heightinm


                    var result = (one.toDouble())/height3

                    tvInput?.text = result.toString()
                if(result>30){
                    var intent = Intent(this,obesity::class.java)
                    Toast.makeText(this, "Kuch toh karle bhai", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                }else if(result>25){
                    var intent2 = Intent(this,overWeight::class.java)
                   startActivity(intent2)
                    Toast.makeText(this, "You need to exercise daily", Toast.LENGTH_SHORT).show()
                }else if(result>19){
                    var intent3=Intent(this,normal::class.java)
                    startActivity(intent3)
                    Toast.makeText(this, "congratulations!\nyou are fit ", Toast.LENGTH_SHORT).show()
                }
                else{
                    var intent4= Intent(this,underWeight::class.java)
                    startActivity(intent4)
                    Toast.makeText(this, "jab hawa chale jheb mai\n pathar leke ghumna", Toast.LENGTH_SHORT).show()
                }

            }








        }


    }}



