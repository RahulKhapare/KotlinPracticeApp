package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityImageViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class ImageViewActivity : AppCompatActivity() {

    val activity = this@ImageViewActivity;
    lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_image_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_view);
        init()
    }

    fun init() {
        (this@ImageViewActivity as? AppCompatActivity)?.supportActionBar?.title = "Image View "
        addDynamicImage();
    }

    fun addDynamicImage() {

        val imageView = ImageView(activity)
        // setting height and width of imageview
        imageView.layoutParams = LinearLayout.LayoutParams(400, 400)
        imageView.x = 20F // setting margin from left
        imageView.y = 20F // setting margin from top

        // accessing our custom image which we added in drawable folder
        val imgResId = R.mipmap.ic_launcher
        var resId = imgResId

        // button onClick listener
        binding.btnAddImage?.setOnClickListener {
            imageView.setImageResource(resId)
        }
        // accessing our relative layout from activity_main.xml
        // Add ImageView to LinearLayout
        binding.root?.addView(imageView) // adding image to the layout

    }
}