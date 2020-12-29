package com.example.dailydrama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        supportActionBar!!.hide()
      setSingleEvent(mainGridayout)


    }

    private fun setSingleEvent(mainGridayout: GridLayout?) {

        var i = 0
        for (i in i until mainGridayout!!.childCount) {
            var cardView: CardView = mainGridayout.getChildAt(i) as CardView

            val finalI = i
            cardView.setOnClickListener {
                if (finalI == 0) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "entertainment")
                    startActivity(intent)

                } else if (finalI == 1) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "health")
                    startActivity(intent)

                } else if (finalI == 2) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "business")
                    startActivity(intent)

                } else if (finalI == 3) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "politics")
                    startActivity(intent)

                } else if (finalI == 4) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "science")
                    startActivity(intent)

                } else if (finalI == 5) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "sports")
                    startActivity(intent)

                } else if (finalI == 6) {

                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("category", "technology")
                    startActivity(intent)

                } else if (finalI == 7) {

                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Startups")
                    startActivity(intent)

                } else if (finalI == 8) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Funny")
                    startActivity(intent)

                } else if (finalI == 9) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","International")
                    startActivity(intent)

                } else if (finalI == 10) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Automobile")
                    startActivity(intent)

                } else if (finalI == 11) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Travel")
                    startActivity(intent)

                } else if (finalI == 12) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Fashion")
                    startActivity(intent)

                } else if (finalI == 13) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Education")
                    startActivity(intent)

                } else if (finalI == 14) {

                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","India")
                    startActivity(intent)

                } else if (finalI == 15) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Covid19")
                    startActivity(intent)

                } else if (finalI == 16) {


                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","IPL2020")
                    startActivity(intent)

                } else if (finalI == 17) {

                    var intent = Intent(this, SettingsActivity::class.java)
                    intent.putExtra("category","Miscellaneous")
                    startActivity(intent)

                }
            }
        }
    }
}