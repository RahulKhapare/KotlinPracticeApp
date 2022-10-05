package com.rak_developer.kotlinpracticeapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityBarViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityButtonViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMiscViewBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val activity = this@MainActivity;
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        onClick()
    }

    fun onClick() {

//        binding.btnTextView?.setOnClickListener()
//        {
//
//        }

        binding.btnTextView?.setOnClickListener(this@MainActivity)
        binding.btnScrollView?.setOnClickListener(this@MainActivity)
        binding.btnImageView?.setOnClickListener(this@MainActivity)
        binding.btnListView?.setOnClickListener(this@MainActivity)
        binding.btnButtonView?.setOnClickListener(this@MainActivity)
        binding.btnEditText?.setOnClickListener(this@MainActivity)
        binding.btnLayouts?.setOnClickListener(this@MainActivity)
        binding.btnBar?.setOnClickListener(this@MainActivity)
        binding.btnSwitcher?.setOnClickListener(this@MainActivity)
        binding.btnTimeAndDatePicker?.setOnClickListener(this@MainActivity)
        binding.btnMisc?.setOnClickListener(this@MainActivity)
        binding.btnJetpack?.setOnClickListener(this@MainActivity)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnTextView -> {
                intent = Intent(this, TextViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnScrollView -> {
                intent = Intent(this, ScrollViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnImageView -> {
                intent = Intent(this, ImageViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnListView -> {
                intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnButtonView -> {
                intent = Intent(this, ButtonViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnEditText -> {
                intent = Intent(this, EditTextViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnLayouts -> {
                intent = Intent(this, LayoutViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnBar -> {
                intent = Intent(this, BarViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSwitcher -> {
                intent = Intent(this, SwitcherViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnTimeAndDatePicker -> {
                intent = Intent(this, TimeDateViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMisc -> {
                intent = Intent(this, MiscViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnJetpack -> {
                intent = Intent(this, JetpackComponentActivity::class.java)
                startActivity(intent)
            }

        }
    }

}