package com.minjee.basicmvvmexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.minjee.basicmvvmexample.R

/*
 *      MainActivity
 *      - opens our fragment which has the UI
 */
class MainActivity : AppCompatActivity(R.layout.navigation_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

    }
}
