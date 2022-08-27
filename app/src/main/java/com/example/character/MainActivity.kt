package com.example.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.character.Fragment.Man1Fragment
import com.example.character.Fragment.Man2Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigationView: BottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.bottomNavigationView) }

    private val  man1Fragment= Man1Fragment()
    private val  man2Fragment= Man2Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repFragment(man1Fragment);

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_tapMot -> repFragment(man1Fragment)
                R.id.ic_tapHai -> repFragment(man2Fragment)
            }
            true
        }

    }

    private fun repFragment(fragment: Fragment){
        if (fragment !=null){
            val transaction =supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()

        }
    }
}

