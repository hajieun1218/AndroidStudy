package com.sist.mylistproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*

class MainListAdapter(val context: Context,val memberList:ArrayList<Member>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View=LayoutInflater.from(context).inflate(R.layout.item_list,null)
        
        val name=view.findViewById<TextView>(R.id.nameTextView)
        val addr=view.findViewById<TextView>(R.id.addrTextView)
        val tel=view.findViewById<TextView>(R.id.telTextView)

        // position : 리스트 인덱스 번호
        val member=memberList[position]
        name.text=member.name
        addr.text=member.addr
        tel.text=member.tel

        return view
    }

    override fun getItem(position: Int): Any {
        return memberList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return memberList.size
    }

}