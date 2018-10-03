package de.dominikwieners.smarttoast

import android.content.Context
import android.support.annotation.NonNull
import android.widget.Toast

class SmartToast{

    companion object {
        fun normal(context:Context, message:CharSequence):Toast{
            return normal(context, message, Toast.LENGTH_LONG)
        }

        fun normal(context: Context, message: CharSequence, duration:Int):Toast{
            return Toast.makeText(context, message, duration)
        }
    }


}