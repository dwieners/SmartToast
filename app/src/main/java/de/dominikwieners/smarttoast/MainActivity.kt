package de.dominikwieners.smarttoast

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SmartToast.successSnack(this, "YOUR TEXT", Snackbar.LENGTH_SHORT).show()
        SmartToast.successSnack(this, "YOUR TEXT").show()

        SmartToast.infoSnack(this, "YOUR TEXT", Snackbar.LENGTH_LONG).show()
        SmartToast.infoSnack(this, "YOUR TEXT").show()

        SmartToast.errorSnack(this, "YOUR TEXT", Snackbar.LENGTH_LONG).show()
        SmartToast.errorSnack(this, "YOUR TEXT").show()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            SmartToast.customSnack(this, "YOUR TEXT", SmartToast.DEFAULT_TEXT_COLOR,
                    resources.getColor(android.R.color.holo_purple, theme),
                    Snackbar.LENGTH_LONG).show()
        }


        SmartToast.normalToast(this,"YOUR TEXT", Toast.LENGTH_LONG).show()
        SmartToast.normalToast(this,"YOUR TEXT").show()

        SmartToast.successToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
        SmartToast.successToast(this, "YOUR TEXT").show()

        SmartToast.infoToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
        SmartToast.infoToast(this, "YOUR TEXT").show()

        SmartToast.errorToast(this, "YOUR TEXT", Toast.LENGTH_LONG).show()
        SmartToast.errorToast(this, "YOUR TEXT").show()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            SmartToast.customToast(this, "YOUR TEXT", SmartToast.DEFAULT_TEXT_COLOR,
                    resources.getColor(android.R.color.holo_purple, theme),
                    Toast.LENGTH_LONG).show()
        }


    }
}
