package com.example.dailydrama

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.littlemango.stacklayoutmanager.StackLayoutManager
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main1.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter
    private var articles = mutableListOf<Article>()
    var pageNum = 1
    var totalResults = -1
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name = intent.getStringExtra("category")
        toolbar.setTitle(name+" (today's updates)")

        setSupportActionBar(findViewById(R.id.toolbar))

        progressBar_main.visibility = View.VISIBLE

        //creating adapter object
        adapter = NewsAdapter(this, articles)
        news_list1.adapter = adapter
        //news_list.layoutManager = LinearLayoutManager(this@MainActivity)

        val layoutManager = StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        layoutManager.setPagerMode(true)
        layoutManager.setPagerFlingVelocity(3000)
        news_list1.layoutManager = layoutManager

        layoutManager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {

                container.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
                toolbar.setBackgroundColor(Color.parseColor(ColorPicker.getColor1()))

                i++//increamenting the count

                Log.d(
                    "mainActivity",
                    "first visible item-${layoutManager.getFirstVisibleItemPosition()}"
                )
                Log.d("mainActivity", "total count-${layoutManager.itemCount}")
                if (totalResults > layoutManager.itemCount && layoutManager.getFirstVisibleItemPosition() >= layoutManager.itemCount - 5) {
                    //next page code

                    pageNum++
                    getNews()//again calling 2nd time

                }

            }
        })

        getNews()//function calling 1st time

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            val intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "hey i have got this news from DailyDrama Entertainment android app.. " + articles.get(
                    layoutManager.getFirstVisibleItemPosition()
                ).url
            )
            startActivity(Intent.createChooser(intent, "share this news using..."))
            Log.d("count", layoutManager.getFirstVisibleItemPosition().toString() + "value of i=$i")
//    Snackbar.make(view, "coming soon...", Snackbar.LENGTH_LONG)
//    .setAction("Action", null).show()
        }
    }

    private fun getNews() {

        Log.d("getNews", "request for page  $pageNum")

        var name = intent.getStringExtra("category")
        val news = NewService.newsInstance.getHeadlines("in", pageNum, name, "popularity")

        news.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                progressBar_main.visibility = View.GONE
                Log.d("error", t.toString())
                Toasty.error(
                    applicationContext,
                    "error in fetching news,check internet connection",
                    Toast.LENGTH_SHORT,
                    true
                ).show();
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {

                val mynews = response.body()

                if (mynews != null) {
                    progressBar_main.visibility = View.GONE

                    Toasty.success(applicationContext, "Swipe up to see more!!  ", Toast.LENGTH_SHORT, true).show();

                    Log.d("ifblock", response.body().toString())

                    totalResults = mynews.totalResults    //will get total count here

                    articles.addAll(mynews.articles)
                    adapter.notifyDataSetChanged()
                } else {
                    Toasty.warning(
                        applicationContext,
                        "getting null response",
                        Toast.LENGTH_SHORT,
                        true
                    ).show();
                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                var intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("category","Settings")
                startActivity(intent)
            }
            R.id.action_share -> {
                Toasty.success(this, "coming soon..", Toast.LENGTH_SHORT).show()
            }
            R.id.action_about_us -> {
                Toasty.success(this, "coming soon..", Toast.LENGTH_SHORT).show()

            }
            R.id.action_sort -> {
                Toasty.success(this, "coming soon..", Toast.LENGTH_SHORT).show()

                //calling to category activity
            }
        }

        return true
    }
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
}