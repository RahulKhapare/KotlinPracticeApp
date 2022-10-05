package com.rak_developer.kotlinpracticeapp.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivitySwitcherViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class SwitcherViewActivity : AppCompatActivity() {

    val activity = this@SwitcherViewActivity;
    lateinit var binding: ActivitySwitcherViewBinding

    private val languages = arrayOf("Java", "Python", "Kotlin", "Scala", "C++")
    private var index1 = 0
    private var index2 = 0

    private val flowers = intArrayOf(
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round, R.drawable.ic_launcher_background
    )
    private var indexImage1 = 0
    private var indexImage2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_switcher_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_switcher_view);
        init()
    }

    fun init() {
        (this@SwitcherViewActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Switcher View "

        switch()
        dynamicSwitch()
        textSwitcher()
        dynamicTextSwitcher()
        imageSwitcher()
        dynamicImageSwitcher()
    }

    fun switch() {
        binding.switch1?.setOnCheckedChangeListener({ _, isChecked ->
            val message = if (isChecked) "Switch1:ON" else "Switch1:OFF"
            Toast.makeText(
                activity, message,
                Toast.LENGTH_SHORT
            ).show()
        })

        binding.switch2?.setOnCheckedChangeListener({ _, isChecked ->
            val message = if (isChecked) "Switch2:ON" else "Switch2:OFF"
            Toast.makeText(
                activity, message,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    fun dynamicSwitch() {
        // Creating switch1 and switch2 programmatically
        val switch1 = Switch(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        switch1.layoutParams = layoutParams
        switch1.text = "Switch1"


        val switch2 = Switch(this)
        val layoutParams2 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        switch2.layoutParams = layoutParams2
        switch2.text = "Switch2"

        // Adding Switches to LinearLayout
        binding.root1?.addView(switch1)
        binding.root1?.addView(switch2)

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = if (isChecked) "SW1:ON" else "SW1:OFF"
            Toast.makeText(
                activity, msg,
                Toast.LENGTH_SHORT
            ).show()
        }

        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = if (isChecked) "SW2:ON" else "SW2:OFF"
            Toast.makeText(
                activity, msg,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun textSwitcher() {
// accessing the TextSwitcher from XML layout
        binding.textSwitcher.setFactory {
            val textView = TextView(activity)
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.BLUE)
            textView
        }
        binding.textSwitcher.setText(languages[index1])

        val textIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        binding.textSwitcher.inAnimation = textIn

        val textOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        binding.textSwitcher.outAnimation = textOut

        // previous button functionality
        binding.btnPrev.setOnClickListener {
            index1 = if (index1 - 1 >= 0) index1 - 1 else 4
            binding.textSwitcher.setText(languages[index1])
        }
        // next button functionality
        binding.btnNext.setOnClickListener {
            index1 = if (index1 + 1 < languages.size) index1 + 1 else 0
            binding.textSwitcher.setText(languages[index1])
        }
    }

    fun dynamicTextSwitcher() {
        val textSwitcher = TextSwitcher(this)

        textSwitcher.setFactory {
            val textView = TextView(activity)
            textView.gravity = Gravity.TOP or Gravity.START
            textView.textSize = 32f
            textView.setPadding(0, 0, 0, 0)
            textView.setTextColor(Color.BLUE)
            textView
        }
        textSwitcher.setText(languages[index2])

        //add textSwitcher in constraint layout
        binding.root2?.addView(textSwitcher)

        val textIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        textSwitcher.inAnimation = textIn

        val textOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        textSwitcher.outAnimation = textOut

        // previous button functionality
        binding.btnPrevDynamic.setOnClickListener {
            index2 = if (index2 - 1 >= 0) index2 - 1 else 4
            textSwitcher.setText(languages[index2])
        }
        // next button functionality
        binding.btnNextDynamic.setOnClickListener {
            index2 = if (index2 + 1 < languages.size) index2 + 1 else 0
            textSwitcher.setText(languages[index2])
        }
    }

    fun imageSwitcher() {

        binding.imgSwitch?.setFactory({
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })

        // set the method and pass array as a parameter
        binding.imgSwitch?.setImageResource(flowers[indexImage1])

        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        binding.imgSwitch?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        binding.imgSwitch?.outAnimation = imgOut

        // previous button functionality
        binding.btnPrevImage.setOnClickListener {
            indexImage1 = if (indexImage1 - 1 >= 0) indexImage1 - 1 else 2
            binding.imgSwitch?.setImageResource(flowers[indexImage1])
        }
        // next button functionality
        binding.btnNextImage.setOnClickListener {
            indexImage1 = if (indexImage1 + 1 < flowers.size) indexImage1 + 1 else 0
            binding.imgSwitch?.setImageResource(flowers[indexImage1])
        }
    }

    fun dynamicImageSwitcher() {

        // create the ImageSwitcher
        val imgSwitcher = ImageSwitcher(this)

        imgSwitcher?.setFactory({
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(20, 20, 20, 20)
            imgView
        })

        //add ImageSwitcher in constraint layout
        binding.root3?.addView(imgSwitcher)

        // set the method and pass array as a parameter
        imgSwitcher?.setImageResource(flowers[indexImage2])

        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        imgSwitcher?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        imgSwitcher?.outAnimation = imgOut

        // previous button functionality
        binding.btnPrevImageDynamic.setOnClickListener {
            indexImage2 = if (indexImage2 - 1 >= 0) indexImage2 - 1 else 1
            imgSwitcher?.setImageResource(flowers[indexImage2])
        }
        // next button functionality
        binding.btnNextImageDynamic.setOnClickListener {
            indexImage2 = if (indexImage2 + 1 < flowers.size) indexImage2 + 1 else 0
            imgSwitcher?.setImageResource(flowers[indexImage2])
        }

    }
}