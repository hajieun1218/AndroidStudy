package com.sist.lastapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.home_item.view.*
import org.json.JSONObject
import org.w3c.dom.Text
import java.net.URL

class HomeActivity : AppCompatActivity() {
    var dataList = ArrayList<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fetchJsonData().execute()

        // Item click listener
        homeListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var cateno=dataList.get(position).get("cateno")
            //Toast.makeText(this, "선택번호:$cateno", Toast.LENGTH_SHORT).show()
            var title=dataList.get(position).get("title")
            var subject=dataList.get(position).get("subject")

            // 데이터 넘기기
            var intent=Intent(this,CateFoodActivity::class.java)
            intent.putExtra("cateno",cateno.toString())
            intent.putExtra("title",title.toString())
            intent.putExtra("subject",subject.toString())
            // 화면이동
            startActivity(intent)
        }
    }


    inner class fetchJsonData() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            return URL("http://211.238.142.186:3355/category2").readText(
                Charsets.UTF_8
            )
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val jsonObj = JSONObject(result)
            val usersArr = jsonObj.getJSONArray("category")
            for (i in 0 until usersArr.length()) {
                val singleUser = usersArr.getJSONObject(i)

                val map = HashMap<String, String>()
                map["title"] = singleUser.getString("title")
                map["subject"] = singleUser.getString("subject")
                map["image"] = singleUser.getString("poster")
                map["cateno"] = singleUser.getString("cateno")
                dataList.add(map)
            }

            // val homeListView=findViewById<ListView>(R.id.homeListView)
            homeListView.adapter = HomeAdapter(this@HomeActivity, dataList)
        }
    }


    // 메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.home_menu -> {
                // 화면 이동
                var intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.home_pop -> {
                var intent= Intent(this,PopActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.home_recommend -> {
                var intent= Intent(this,RecommendActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.home_recipe -> {
                var intent= Intent(this,RecipeActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.home_news -> {
                var intent= Intent(this,NewsActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}