package com.example.activityresult

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // handle the returned Uri
    }

    // registerForActivityResult() = API para registrat o callback resultante.
    // Pega uma ActivityResultContract e uma ActivityResultCallback
    // e retorna uma ActivityResultLauncher, que será usada pra iniciar a outra Activity.
    // É seguro chamar a registerForActivityResult() antes que a activity ou fragment é criada,
    // permitindo que seja usada diretamente quando se declara variáveis membro para as instâncias
    // retornadas da ActivityResultLauncher.

    // Note: You must call registerForActivityResult() before the fragment or activity is created;
// you cannot launch the ActivityResultLauncher until the fragment or activity's Lifecycle has
// reached CREATED.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selectButton = findViewById<Button>(R.id.select_button)

        selectButton.setOnClickListener {
            // Pass in the mime type you'd like to allow the user to select
            // as the input
            getContent.launch("image/*")
        }
    }


}