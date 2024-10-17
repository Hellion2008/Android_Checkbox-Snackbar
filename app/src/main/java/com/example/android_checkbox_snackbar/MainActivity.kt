package com.example.android_checkbox_snackbar

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editTextET: EditText
    private lateinit var textViewTV: TextView

    private lateinit var saveDataBTN: Button
    private lateinit var deleteDataBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextET = findViewById(R.id.editTextET)
        textViewTV = findViewById(R.id.textViewTV)

        saveDataBTN = findViewById(R.id.saveDataBTN)
        deleteDataBTN = findViewById(R.id.deleteDataBTN)

        saveDataBTN.setOnClickListener(this)
        deleteDataBTN.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.saveDataBTN -> {
                textViewTV.setText(editTextET.text)
            }

            R.id.deleteDataBTN -> {
                Snackbar.make(p0, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                    .setAction("Удалить") {
                        editTextET.text.clear()
                        textViewTV.setText("")
                        Snackbar.make(p0, "Данные удалены", Snackbar.LENGTH_LONG).show()
                    }
                    .setActionTextColor(Color.BLUE)
                    .show()
            }
        }
    }


}