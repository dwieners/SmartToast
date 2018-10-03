package de.dominikwieners.smarttoast

import android.content.Context
import android.widget.Toast

class SmartToast{

    fun normal(context:Context, message:Int):Toast{
        return normal(context, message, Toast.LENGTH_LONG)
    }

    fun normal(context: Context, message: Int, duration:Int):Toast{
        return Toast.makeText(context, context.getString(message), duration)
    }

}