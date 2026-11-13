package com.example.pr6_trembach

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            goToSplash()
        }
    }

    fun goToSignIn() {
        replaceFragment(SignInFragment(), addToStack = true)
    }

    fun goToMain() {
        replaceFragment(MainFragment(), addToStack = true)
    }

    fun goToChats() {
        replaceFragment(ChatsFragment(), addToStack = true)
    }

    fun goToMovies() {
        replaceFragment(MoviesFragment(), addToStack = true)
    }

    fun goToSplash() {
        replaceFragment(SplashFragment(), addToStack = false)
    }

    private fun replaceFragment(fragment: Fragment, addToStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
}