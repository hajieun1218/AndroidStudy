package com.sist.mylistproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var memList= arrayListOf<Member>(
        Member("홍길동","서울","010-0000-0000"),
        Member("심청이","경기","010-1111-1111"),
        Member("박문수","인천","010-2222-2222"),
        Member("이순신","강원","010-3333-3333"),
        Member("춘향이","제주","010-4444-4444")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=MainListAdapter(this,memList)
        mainListView.adapter=adapter
    }
}