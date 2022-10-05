package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import android.widget.ScrollView
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityScrollViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class ScrollViewActivity : AppCompatActivity() {

    val activity = this@ScrollViewActivity;
    lateinit var binding: ActivityScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_scroll_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scroll_view)
        init()
    }

    fun init() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Scroll View "
        dynamicScollView()
        dynamicHorizontalScollView()
    }

    fun dynamicScollView() {
        val scrollView = ScrollView(activity)
        val layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        scrollView.layoutParams = layoutParams


        val linearLayout = LinearLayout(activity)
        val linearParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = linearParams

        scrollView.addView(linearLayout)

        val imageView1 = ImageView(activity)
        val params1 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        //setting margin
        params1.setMargins(0, 30, 0, 30)
        //aligning the layout to center of the screen
        params1.gravity = Gravity.CENTER
        imageView1.setLayoutParams(params1)
        //setting our own downloaded/custom image to the imageView
        imageView1.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(imageView1)

        val imageView2 = ImageView(activity)
        val params2 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params2.setMargins(0, 0, 0, 30)
        params2.gravity = Gravity.CENTER
        imageView2.setLayoutParams(params2)
        imageView2.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(imageView2)

        val imageView3 = ImageView(this)
        val params3 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params3.setMargins(0, 0, 0, 30)
        params3.gravity = Gravity.CENTER
        imageView3.setLayoutParams(params3)
        imageView3.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(imageView3)

        val imageView4 = ImageView(this)
        val params4 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params4.setMargins(0, 0, 0, 30)
        params4.gravity = Gravity.CENTER
        imageView4.setLayoutParams(params4)
        imageView4.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(imageView4)

        binding.root1?.addView(scrollView)
    }

    fun dynamicHorizontalScollView() {

        val horizontalScrollView = HorizontalScrollView(activity)
        //setting height and width
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        horizontalScrollView.layoutParams = layoutParams

        val linearLayout = LinearLayout(this)
        //setting height and width
        val linearParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayout.layoutParams = linearParams

        //adding horizontal scroll view to the layout
        horizontalScrollView.addView(linearLayout)

        val image1 = ImageView(this)
        //setting height and width
        val params1 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image1.layoutParams = params1
        //accessing images that we downloaded and copied to
        // drawable folder and setting it to imageview
        image1.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(image1)

        val image2 = ImageView(this)
        //setting height and width
        val params2 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image2.layoutParams = params2
        //accessing images that we downloaded and copied to
        // drawable folder and setting it to imageview
        image2.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(image2)

        val image3 = ImageView(activity)
        //setting height and width
        val params3 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image3.layoutParams = params3
        //accessing images that we downloaded and copied to
        // drawable folder and setting it to imageview
        image3.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(image3)

        val image4 = ImageView(activity)
        //setting height and width
        val params4 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image4.layoutParams = params4
        //accessing images that we downloaded and copied to
        // drawable folder and setting it to imageview
        image4.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(image4)

        val image5 = ImageView(activity)
        //setting height and width
        val params5 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image5.layoutParams = params5
        //accessing images that we downloaded and copied to
        // drawable folder and setting it to imageview
        image5.setImageResource(R.mipmap.ic_launcher)
        linearLayout.addView(image5)

        //accessing the relative layout where the scrollview will be active
        binding.root2?.addView(horizontalScrollView)

    }
}