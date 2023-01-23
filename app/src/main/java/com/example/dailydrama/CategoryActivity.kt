package com.example.dailydrama

import android.app.AlertDialog
import android.content.DialogInterface
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
    //this method will execute after clicking on back button.
    //Alert dialog
    @Override
    override fun onBackPressed() {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Exit App!")
        alertDialog.setMessage("Do you really want to exit app?")
        alertDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24)
        alertDialog.setCancelable(false)

        var listener = DialogInterface.OnClickListener { dialogInterface, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                super.onBackPressed()
                finish()
            } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                dialogInterface.dismiss()

            } else if (which == DialogInterface.BUTTON_NEUTRAL) {
                dialogInterface.dismiss()
            }

        }

        alertDialog.setPositiveButton("yes", listener)
        alertDialog.setNegativeButton("no", listener)
        alertDialog.setNeutralButton("cancel", listener)
        alertDialog.show()


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