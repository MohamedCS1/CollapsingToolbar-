package com.example.myapplicationf

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import android.animation.Animator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        val appBarLayout = findViewById<AppBarLayout>(R.id.my_appbarlayout)

        val tv = findViewById<TextView>(R.id.hint_tv)


        fun animateTextViewTextChange(
            textView: TextView,
            duration: Int, newText: String?
        ) {
            textView.animate().alpha(0f).setDuration(duration.toLong())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationEnd(animation: Animator) {
                        textView.text = newText
                        textView.animate().alpha(1f).setDuration(duration.toLong())
                            .start()
                    }

                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                }).start()
        }

        var x = 0
        appBarLayout.addOnOffsetChangedListener(object :AppBarLayout.OnOffsetChangedListener{
            @SuppressLint("SetTextI18n")
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (verticalOffset == -641)
                {
                    animateTextViewTextChange(tv ,800 ,"Scroll to Bottom")
                    x = 1
                }
                else if (verticalOffset == 0 && x == 1)
                {
                    animateTextViewTextChange(tv ,800 ,"Scroll to Top")

                }
            }
        }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu ,menu)
        return super.onCreateOptionsMenu(menu)
    }
}