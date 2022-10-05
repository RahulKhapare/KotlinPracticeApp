package com.rak_developer.kotlinpracticeapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityButtonViewBinding

class ButtonViewActivity : AppCompatActivity() {

    val activity = this@ButtonViewActivity;
    lateinit var binding: ActivityButtonViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_button_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_button_view);
        init()
    }

    fun init() {
        (this@ButtonViewActivity as? AppCompatActivity)?.supportActionBar?.title = "Button View "

        normalButton()
        imageButton()
        dynamicImageButton()
        radioButton()
        dynamicRadioGroup()
    }

    fun normalButton() {
        binding.btnNormal?.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Button Clicked", Toast.LENGTH_SHORT).show()
        })
    }

    fun imageButton() {
        binding.imageBtn?.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(binding.etxNumOne.text.toString())) {
                Toast.makeText(activity, "Enter Number One", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(binding.etxNumTwo.text.toString())) {
                Toast.makeText(activity, "Enter Number Two", Toast.LENGTH_SHORT).show()
            } else {
                val num1 = Integer.parseInt(binding.etxNumOne.text.toString())
                val num2 = Integer.parseInt(binding.etxNumTwo.text.toString())
                Toast.makeText(
                    applicationContext,
                    "Sum of the numbers = " + (num1 + num2),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun dynamicImageButton() {
        val imgBtn = ImageButton(activity)
        imgBtn.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        imgBtn.setImageResource(androidx.appcompat.R.drawable.abc_ic_clear_material)

        // Adding ImageButton in LinearLayout
        binding.root1.addView(imgBtn)

        imgBtn.setOnClickListener {
            if (TextUtils.isEmpty(binding.etxNumThree.text.toString())) {
                Toast.makeText(activity, "Enter Number Three", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(binding.etxNumFour.text.toString())) {
                Toast.makeText(activity, "Enter Number Four", Toast.LENGTH_SHORT).show()
            } else {
                val num1 = Integer.parseInt(binding.etxNumThree.text.toString())
                val num2 = Integer.parseInt(binding.etxNumFour.text.toString())
                Toast.makeText(
                    applicationContext,
                    "Sum of the numbers = " + (num1 * num2),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun radioButton() {

        // Get radio group selected item using on checked change listener
        binding.radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(
                    activity, " On checked change :" +
                            " ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            })

        binding.btnRadioSelected?.setOnClickListener(View.OnClickListener {
// Get the checked radio button id from radio group
            var id: Int = binding.radioGroup.checkedRadioButtonId
            if (id != -1) { // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                Toast.makeText(
                    applicationContext, "On button click :" +
                            " ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // If no radio button checked in this radio group
                Toast.makeText(
                    applicationContext, "On button click :" +
                            " nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View) {
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(binding.radioGroup.checkedRadioButtonId)
        Toast.makeText(
            applicationContext, "On click : ${radio.text}",
            Toast.LENGTH_SHORT
        ).show()
    }

    @SuppressLint("ResourceType")
    fun dynamicRadioGroup() {

        // Create RadioButton programmatically
        val radioButton1 = RadioButton(this)
        radioButton1.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton1.setText("Black")
        radioButton1.id = 1

        val radioButton2 = RadioButton(this)
        radioButton2.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton2.setText("White")
        radioButton2.id = 2

        val radioButton3 = RadioButton(this)
        radioButton3.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton3.setText("Blue")
        radioButton3.id = 3

        if (binding.radioGroupDynamic != null) {
            binding.radioGroupDynamic.addView(radioButton1)
            binding.radioGroupDynamic.addView(radioButton2)
            binding.radioGroupDynamic.addView(radioButton3)

            binding.radioGroupDynamic.setOnCheckedChangeListener { group, checkedId ->
                var string = getString(R.string.you_selected)
                string += " " + getString(
                    if (checkedId == 1) R.string.black
                    else if (checkedId == 2) R.string.white
                    else R.string.blue
                )
                Toast.makeText(applicationContext, string, Toast.LENGTH_SHORT).show()
            }
        }

    }
}