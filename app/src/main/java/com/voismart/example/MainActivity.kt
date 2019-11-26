package com.voismart.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.voismart.crypto.Crypto
import com.voismart.crypto.EncryptionHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Crypto.init(this, BuildConfig.APPLICATION_ID)
        button?.setOnClickListener { onRunClick() }
    }

    private fun onRunClick() {
        val text = plainText?.text.toString()
        if (text.isBlank()) {
            Toast.makeText(this, R.string.text_empty_plain_text, Toast.LENGTH_SHORT).show()
        } else {
            val helper = EncryptionHelper.getInstance()
            val encrypted = helper.encrypt(text)
            cypherText?.text = encrypted
            val decrypted = helper.decrypt(encrypted)
            decryptedText?.text = decrypted
        }
    }
}
