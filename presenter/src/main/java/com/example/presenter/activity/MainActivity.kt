package com.example.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presenter.R
import com.example.presenter.fragment.AccountFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val fragment = supportFragmentManager.findFragmentById(R.id.fr_container)
            if (fragment == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fr_container, AccountFragment())
                    .commit()
            }
        }
    }
