package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTimeDateViewBinding
import java.util.*

class TimeDateViewActivity : AppCompatActivity() {

    val activity = this@TimeDateViewActivity;
    lateinit var binding: ActivityTimeDateViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_time_date_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_time_date_view);
        init()
    }

    fun init() {
        (this@TimeDateViewActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Time & Date Picker View "

        timePicker()
        dynamicTimePicker()
        datePicker()
        dynamicDatePicker()
    }

    fun timePicker() {
        binding.timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            if (binding.txtTime1 != null) {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0" + minute else minute
                // display format of time
                val msg = "Time is: $hour : $min $am_pm"
                binding.txtTime1.text = msg
                binding.txtTime1.visibility = ViewGroup.VISIBLE
            }
        }
    }

    fun dynamicTimePicker() {
//create textView from XML file
        val txtView = TextView(this)
        // create TimePicker programmatically
        val timePicker = TimePicker(this)

        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        timePicker.layoutParams = layoutParams
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""

            // AM_PM decider logic
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            if (txtView != null) {
                val hour = if (hour < 10) "0$hour" else hour
                val min = if (minute < 10) "0$minute" else minute
                // display format of time
                val msg = "Time is: $hour : $min $am_pm"
                txtView.text = msg
                txtView.visibility = ViewGroup.VISIBLE
            }
        }
        binding.root1?.addView(timePicker)
        binding.root1?.addView(txtView)
    }

    fun datePicker() {
        val today = Calendar.getInstance()
        binding.datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun dynamicDatePicker() {
        val datePicker = DatePicker(this)
        val today = Calendar.getInstance()
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        datePicker.layoutParams = layoutParams

        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }

        binding.root2?.addView(datePicker)
    }
}