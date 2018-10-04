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
        val DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF")

        fun normal(@NonNull context:Context, @StringRes message:CharSequence):Toast{
            return normal(context, message, Toast.LENGTH_LONG)
        }

        fun normal(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration:Int):Toast{
            return Toast.makeText(context, DEFAULT_TEXT_COLOR, duration)
        }

        fun success(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR , SUCCESS_COLOR, duration)
        }

        fun success(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR, SUCCESS_COLOR, Toast.LENGTH_LONG)
        }

        fun info(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR, INFO_COLOR, duration)
        }

        fun info(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR, INFO_COLOR, Toast.LENGTH_LONG)
        }

        fun error(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR, ERROR_COLOR, duration)
        }

        fun error(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return custom(context, message, DEFAULT_TEXT_COLOR, ERROR_COLOR, Toast.LENGTH_LONG)
        }

        fun custom(@NonNull context: Context, @StringRes message: CharSequence, @ColorInt textColor:Int, @ColorInt toastColor:Int, @NonNull duration:Int) : Toast{
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.toast_layout, null)
            val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
            val root:View = toastLayout.findViewById(R.id.toast_root)

            root.background.setColorFilter(toastColor, PorterDuff.Mode.SRC_IN)
            toastTextView.setTextColor(textColor)

            toastTextView.text = message
            currentToast.view = toastLayout
            return currentToast
        }

    }

}