package com.example.pr6_trembach

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editEmail = view.findViewById<EditText>(R.id.editEmail)
        val editPassword = view.findViewById<EditText>(R.id.editPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val textError = view.findViewById<TextView>(R.id.textError)

        val sharedPref = requireContext().getSharedPreferences("DATA", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                textError.text = "Заполните все поля!"
                return@setOnClickListener
            }

            if (password.length < 8) {
                textError.text = "Пароль должен быть не менее 8 символов!"
                return@setOnClickListener
            }

            val savedLogin = sharedPref.getString("LOGIN", null)
            val savedPassword = sharedPref.getString("PASSWORD", null)

            if (savedLogin == null || savedPassword == null) {
                val prefEditor = sharedPref.edit()
                prefEditor.putString("LOGIN", email)
                prefEditor.putString("PASSWORD", password)
                prefEditor.apply()
                Toast.makeText(requireContext(), "Регистрация успешна!", Toast.LENGTH_SHORT).show()

                (activity as? MainActivity)?.goToMain()
            } else {
                if (savedLogin == email && savedPassword == password) {
                    (activity as? MainActivity)?.goToMain()
                } else {
                    textError.text = "Неверный логин или пароль!"
                }
            }
        }
    }
}