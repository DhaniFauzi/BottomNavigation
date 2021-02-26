package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNav = findViewById<BottomNavigationView>(R.id.BottomNav)
        var frameLayout = findViewById<FrameLayout>(R.id.frameLayout)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.Home ->{
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.Profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.Setting ->{
                    settingFragment = SettingFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,settingFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}