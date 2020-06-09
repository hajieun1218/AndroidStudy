package com.sist.mykotlinapplication_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
/*
data class A(var a:Int)  ==> VO클래스
 */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 데이터 받기
        val height=intent.getStringExtra("height").toInt()
        val weight=intent.getStringExtra("weight").toInt()

        val result=weight/Math.pow(height/100.0,2.0)
        
        when {
            result>=35 -> resultTextView.text="고도비만"
            result>=30 -> resultTextView.text="2단계비만"
            result>=25 -> resultTextView.text="1단계비만"
            result>=20 -> resultTextView.text="과체중"
            result>=18.5 -> resultTextView.text="정상"
            else -> resultTextView.text="저체중"
        }

        Toast.makeText(this,"height:$height, weight:$weight, 결과:$result", Toast.LENGTH_LONG).show()
    }
}