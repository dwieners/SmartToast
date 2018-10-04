package de.dominikwieners.smarttoast

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.annotation.ColorInt
import android.support.annotation.NonNull
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
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

        fun customToast(@NonNull context: Context, @StringRes message: CharSequence, @ColorInt textColor:Int, @ColorInt toastColor:Int, @NonNull duration:Int) : Toast{
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

        fun normalToast(@NonNull context:Context, @StringRes message:CharSequence):Toast{
            return normalToast(context, message, Toast.LENGTH_LONG)
        }

        fun normalToast(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration:Int):Toast{
            return Toast.makeText(context, DEFAULT_TEXT_COLOR, duration)
        }

        fun successToast(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR , SUCCESS_COLOR, duration)
        }

        fun successToast(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR, SUCCESS_COLOR, Toast.LENGTH_LONG)
        }

        fun infoToast(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR, INFO_COLOR, duration)
        }

        fun infoToast(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR, INFO_COLOR, Toast.LENGTH_LONG)
        }

        fun errorToast(@NonNull context: Context, @StringRes message: CharSequence, @NonNull duration: Int):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR, ERROR_COLOR, duration)
        }

        fun errorToast(@NonNull context: Context, @StringRes message: CharSequence):Toast{
            return customToast(context, message, DEFAULT_TEXT_COLOR, ERROR_COLOR, Toast.LENGTH_LONG)
        }

        fun customSnack(@NonNull activity: Activity, @StringRes message: CharSequence, @ColorInt textColor: Int, @ColorInt snackbarColor:Int, @NonNull duration: Int) : Snackbar{

            // Get Snackbr
            val snackbar = Snackbar.make(activity.findViewById(android.R.id.content), "", duration)

            // Get the Snackbar's layout view
            val layout = snackbar.view as Snackbar.SnackbarLayout

            // Hide the text
            val textView = layout.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            textView.visibility = View.INVISIBLE

            // Inflate layout
            val snackView = (activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.snack_layout, null)

            // Set background color
            layout.background.setColorFilter(snackbarColor, PorterDuff.Mode.SRC_IN)

            val snackText = snackView.findViewById<TextView>(R.id.snack_text)
            snackText.text = message
            snackText.setTextColor(textColor)

            layout.addView(snackView, 0)
            return snackbar
        }

        fun successSnack(@NonNull activity: Activity, @StringRes message: CharSequence) : Snackbar{
            return successSnack(activity, message, Snackbar.LENGTH_LONG)
        }

        fun successSnack(@NonNull activity: Activity, @StringRes message: CharSequence, @NonNull duration: Int) : Snackbar{
            return customSnack(activity, message, DEFAULT_TEXT_COLOR, SUCCESS_COLOR, Snackbar.LENGTH_LONG)
        }

        fun infoSnack(@NonNull activity: Activity, @StringRes message: CharSequence) : Snackbar{
            return infoSnack(activity, message, Snackbar.LENGTH_LONG)
        }

        fun infoSnack(@NonNull activity: Activity, @StringRes message: CharSequence, @NonNull duration: Int) : Snackbar{
            return customSnack(activity, message, DEFAULT_TEXT_COLOR, INFO_COLOR, duration)
        }

        fun errorSnack(@NonNull activity: Activity, @StringRes message: CharSequence) : Snackbar{
            return errorSnack(activity, message, Snackbar.LENGTH_LONG)
        }

        fun errorSnack(@NonNull activity: Activity, @StringRes message: CharSequence, @NonNull duration: Int) : Snackbar{
            return customSnack(activity, message, DEFAULT_TEXT_COLOR, ERROR_COLOR, duration)
        }

    }

}