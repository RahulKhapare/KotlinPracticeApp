package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityBarViewBinding

class BarViewActivity : AppCompatActivity() {

    val activity = this@BarViewActivity;
    lateinit var binding: ActivityBarViewBinding

    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bar_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bar_view);
        init()
    }

    fun init() {
        (this@BarViewActivity as? AppCompatActivity)?.supportActionBar?.title = "Bar View "

        seekBar()
        dynamicSeekBar()
        discreteSeekBar()
        ratingBar()
        dynamicRatingBar()
        progressBar()
        dynamicProgressBar()
    }

    fun seekBar() {
        binding.seekBar1?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(
                    activity,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun dynamicSeekBar() {
        val seek = SeekBar(this)
        val lParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lParams.setMargins(50, 50, 50, 50)
        seek.layoutParams = lParams

        // Adding SeekBar to LinearLayout
        binding.root1?.addView(seek)

        seek.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean
                ) {
                    // write custom code when progress is changed
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // write custom code when touch is started.
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // write custom code when touch is stopped
                    Toast.makeText(
                        activity,
                        "SeekBar Progress is: " + seekBar.progress + "%",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    fun discreteSeekBar() {
//accessing the seekbar from our layout
        binding.seekBar2?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //here we can write some code to do something when progress is changed
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //here we can write some code to do something whenever the user touche the seekbar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // show some message after user stopped scrolling the seekbar
                Toast.makeText(
                    activity,
                    "Discrete Value of SeekBar is  " + seekBar.progress,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun ratingBar() {
        if (binding.rBar != null) {
            binding.btnSubmitRating?.setOnClickListener {
                val msg = binding.rBar.rating.toString()
                Toast.makeText(
                    activity,
                    "Rating is: " + msg, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun dynamicRatingBar() {
        // Create RatingBar
        val rBar = RatingBar(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        rBar.layoutParams = layoutParams
        rBar.stepSize = 1.0.toFloat()
        rBar.numStars = 5

        //create button
        val button = Button(this)
        val layoutParams1 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        button.text = "Submit Rating"

        binding.root2?.addView(rBar)
        binding.root2?.addView(button)

        button?.setOnClickListener {
            val msg = rBar.rating.toString()
            Toast.makeText(
                activity, "Given Rating: " + msg,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun progressBar() {
        // handling click on button
        binding.btnProgress.setOnClickListener {
            // Before clicking the button the progress bar will invisible
            // so we have to change the visibility of the progress bar to visible
            // setting the progressbar visibility to visible
            binding.progressBar.visibility = View.VISIBLE

            i = binding.progressBar.progress

            Thread(Runnable {
                // this loop will run until the value of i becomes 99
                while (i < 100) {
                    i += 1
                    // Update the progress bar and display the current value
                    handler.post(Runnable {
                        binding.progressBar.progress = i
                        // setting current progress to the textview
                        binding.textProgress!!.text = i.toString() + "/" + binding.progressBar.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                // setting the visibility of the progressbar to invisible
                // or you can use View.GONE instead of invisible
                // View.GONE will remove the progressbar
                binding.progressBar.visibility = View.INVISIBLE

            }).start()
        }
    }

    fun dynamicProgressBar() {
        val progressBar = ProgressBar(this)
        //setting height and width of progressBar
        progressBar.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        //accessing our relative layout where the progressBar will add up
        // Add ProgressBar to our layout
        binding.root3?.addView(progressBar)

        //accessing the button which will handle the events,
        // whether to show progressBar or not
        //set a click listener to show/hide progressBar added in RelativeLayout.
        binding.btnProgressDynamic?.setOnClickListener {
            val visibility = if (progressBar.visibility == View.GONE) {
                View.VISIBLE
            } else
                View.GONE
            progressBar.visibility = visibility

            //setting button text
            //if we click "stop loading" button, text of button will change
            // to "start loading.." and vice versa
            val btnText = if (progressBar.visibility == View.GONE)
                "START LOADING..."
            else
                "STOP LOADING"
            binding.btnProgressDynamic.text = btnText
        }
    }
}