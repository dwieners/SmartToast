package de.dominikwieners.smarttoast

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.NonNull
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat.getDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import android.widget.TextView


class SmartToast{

    companion object {

        val ERROR_COLOR = Color.parseColor("#e53935")
        val INFO_COLOR = Color.parseColor("#f9a825")
        val SUCCESS_COLOR = Color.parseColor("#008577")

        fun normal(@NonNull context:Context, @StringRes message:CharSequence):Toast{
            return normal(context, message, Toast.LENGTH_LONG)
        }

        fun normal(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration:Int):Toast{
            return Toast.makeText(context, message, duration)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun success(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, context.getColor(android.R.color.white) , SUCCESS_COLOR, duration)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun success(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, context.getColor(android.R.color.white), SUCCESS_COLOR, Toast.LENGTH_LONG)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun info(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, context.getColor(android.R.color.white), INFO_COLOR, duration)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun info(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, context.getColor(android.R.color.white), INFO_COLOR, Toast.LENGTH_LONG)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun error(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, context.getColor(android.R.color.white), ERROR_COLOR, duration)
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun error(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, context.getColor(android.R.color.white), ERROR_COLOR, Toast.LENGTH_LONG)
        }

        fun custom(@NonNull context: Context, @StringRes message: CharSequence, @ColorInt textColor:Int, @ColorInt toastColor:Int, @NonNull duration:Int) : Toast{
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.toast_layout, null)
            val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
            val root:View = toastLayout.findViewById(R.id.toast_root)

            root.background = getDrawable(context, android.R.drawable.toast_frame)
            root.background.setColorFilter(toastColor, PorterDuff.Mode.SRC_IN)
            toastTextView.setTextColor(textColor)

            toastTextView.text = message
            currentToast.view = toastLayout
            return currentToast
        }

    }

}