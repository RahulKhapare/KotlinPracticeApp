package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityEditTextViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class EditTextViewActivity : AppCompatActivity() {

    val activity = this@EditTextViewActivity;
    lateinit var binding: ActivityEditTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_edit_text_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_text_view);
        init()
    }

    fun init() {
        (this@EditTextViewActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Edit Text View "
        normalEdiText()
        dynamicEdiText()
    }

    fun normalEdiText() {
        binding.btnSubmit1?.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(binding.extNormal.text.toString())) {
                Toast.makeText(
                    activity,
                    "Enter Value", Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    activity,
                    binding.extNormal.text.toString(), Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun dynamicEdiText() {
        val editText = EditText(this)
        editText.setHint("Enter something")
        editText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        editText.setPadding(20, 20, 20, 20)

        // Add EditText to LinearLayout
        binding.root?.addView(editText)

        binding.btnSubmit2?.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(
                    activity,
                    "Enter Value", Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    activity,
                    editText.text.toString(), Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}