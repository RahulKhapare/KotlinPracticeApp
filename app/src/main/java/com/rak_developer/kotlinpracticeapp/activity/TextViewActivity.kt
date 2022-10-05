package com.rak_developer.kotlinpracticeapp.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {

    val activity = this@TextViewActivity;
    lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_text_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_view);
        init()
    }

    fun init() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Text View "
        normalText()
        dynamicText()
        autoTextView()
        dynamicAutoTextView()
        checkedTextView()
        dynamicCheckedTextView()
    }

    fun normalText() {
        //        val textViewNormal = findViewById(R.id.txtNormalText) as TextView
        binding.txtNormalText?.setOnClickListener {
            Toast.makeText(
                activity,
                "Clicked", Toast.LENGTH_LONG
            ).show()
        }
    }

    fun dynamicText() {
        //        val layout = findViewById<RelativeLayout>(R.id.root)
        val textViewDynamic = TextView(activity)
        // setting height and width
        textViewDynamic.layoutParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        // setting text
        textViewDynamic.setText(resources.getString(R.string.app_name))
        textViewDynamic.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
        textViewDynamic.setTextColor(Color.MAGENTA)
        // onClick the text a message will be displayed "HELLO GEEK"
        textViewDynamic.setOnClickListener()
        {
            Toast.makeText(
                activity, resources.getString(R.string.app_name),
                Toast.LENGTH_LONG
            ).show()
        }

        // Add TextView to LinearLayout
        binding.root1?.addView(textViewDynamic)
    }

    fun autoTextView() {
        // Get the array of languages
        val languages = resources.getStringArray(R.array.Languages)
        // Create adapter and add in AutoCompleteTextView
        val adapter = ArrayAdapter(
            activity,
            android.R.layout.simple_list_item_1, languages
        )
        binding.autoTextView.setAdapter(adapter)
        binding.btnSubmit?.setOnClickListener(View.OnClickListener {
            if (!TextUtils.isEmpty(binding.autoTextView.getText().toString())) {
                val enteredText = "Submitted language: " + binding.autoTextView.getText()
                Toast.makeText(activity, enteredText, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Enter language", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun dynamicAutoTextView() {
        val autotextView = AutoCompleteTextView(activity)
        val button = Button(activity)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        autotextView.layoutParams = layoutParams
        button.layoutParams = layoutParams
        layoutParams.setMargins(0, 30, 0, 30)
        autotextView.setHint("Please type language..")
        button.setText("Submit")
        button.setBackgroundResource(R.drawable.button_bg)

        binding.root2?.addView(autotextView)
        binding.root2?.addView(button)

        // Get the array of languages
        val languages = resources.getStringArray(R.array.Languages)
        // Create adapter and add in AutoCompleteTextView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, languages
        )
        autotextView.setAdapter(adapter)

        button?.setOnClickListener(View.OnClickListener {
            if (!TextUtils.isEmpty(autotextView.getText().toString())) {
                val enteredText = "Submitted language: " + autotextView.getText()
                Toast.makeText(activity, enteredText, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Enter language", Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun checkedTextView() {
        binding.checkedTextView.isChecked = false
        binding.checkedTextView.setCheckMarkDrawable(
            android.R.drawable.checkbox_off_background
        )

        binding.checkedTextView.setOnClickListener {
            binding.checkedTextView.isChecked = !binding.checkedTextView.isChecked
            binding.checkedTextView.setCheckMarkDrawable(
                if (binding.checkedTextView.isChecked)
                    android.R.drawable.checkbox_on_background
                else
                    android.R.drawable.checkbox_off_background
            )

            val msg = getString(R.string.msg_shown) + " " +
                    getString(
                        if (binding.checkedTextView.isChecked)
                            R.string.checked else R.string.unchecked
                    )
            Toast.makeText(
                activity, msg,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun dynamicCheckedTextView() {
        val checkedTextView = CheckedTextView(activity)
        checkedTextView.layoutParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //using our strings.xml to set text
        checkedTextView.setText(R.string.app_name)
        //initially the checkbox in unchecked
        checkedTextView.isChecked = false
        checkedTextView.setCheckMarkDrawable(
            android.R.drawable.checkbox_off_background
        )


        //Onclick event for checkbox
        checkedTextView.setOnClickListener {
            checkedTextView.isChecked = !checkedTextView.isChecked
            checkedTextView.setCheckMarkDrawable(
                if (checkedTextView.isChecked)
                    android.R.drawable.checkbox_on_background
                else android.R.drawable.checkbox_off_background
            )

            //using our strings.xml setting the starting message of the toast
            val message = getString(R.string.pre_msg) + " " +
                    if (checkedTextView.isChecked)
                        getString(R.string.checked)
                    else getString(R.string.unchecked)
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }

        // Add Checkbox to RelativeLayout
        binding.root3?.addView(checkedTextView)
    }
}