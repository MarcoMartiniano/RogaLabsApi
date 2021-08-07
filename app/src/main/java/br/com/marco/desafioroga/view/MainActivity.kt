package br.com.marco.desafioroga.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.marco.desafioroga.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        img_finger.setOnClickListener {
            val intent = Intent(this,PostsActivity::class.java)
            startActivity(intent)
        }
    }
}