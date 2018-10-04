package de.dominikwieners.smarttoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SmartToast.customToast(this, "Hallo", android.R.color.white, android.R.color.holo_orange_dark, Toast.LENGTH_LONG).show()
        SmartToast.successSnack(this, "Success", Snackbar.LENGTH_SHORT).show()
    }
}
