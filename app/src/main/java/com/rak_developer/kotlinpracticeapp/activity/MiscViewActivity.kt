package com.rak_developer.kotlinpracticeapp.activity

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMiscViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTimeDateViewBinding

class MiscViewActivity : AppCompatActivity() {

    val activity = this@MiscViewActivity;
    lateinit var binding: ActivityMiscViewBinding

    // declaring variables
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_misc_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_misc_view);
        init()
    }

    fun init() {
        (this@MiscViewActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Misc View "

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        spinner()
        dynamicSpinner()
        textClock()
        dynamicTextClock()
        chronometer()
        dynamicChronometer()
        notification()
        sidUpDown()
    }

    fun spinner() {
        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        if (binding.spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            binding.spinner.adapter = adapter

            binding.spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        activity,
                        "Selected Item : " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun dynamicSpinner() {
        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        //create spinner programmatically
        val spinner = Spinner(this)
        spinner.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        //add spinner in linear layout
        binding.root1?.addView(spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        activity,
                        "Selected Item " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun textClock() {
        binding.btnShowTime?.setOnClickListener {
            binding.txtClockView?.text = "Time: " + binding.txtClock?.text
        }
    }

    fun dynamicTextClock() {
        //create TextClock programmatically
        val textClock = TextClock(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(140, 80, 80, 80)
        textClock.layoutParams = layoutParams
        textClock.format12Hour = "hh:mm:ss a"

        //add textClock in Linear Layout
        binding.root2?.addView(textClock)

        // display time when click the button
        binding.btnShowTimeDynamic?.setOnClickListener {
            binding.txtClockViewDynamic?.text = "Time: " + textClock?.text
        }
    }

    fun chronometer() {
        // access the chronometer from XML file
        //access the button using id
        binding.btnChronometer?.setOnClickListener(object : View.OnClickListener {

            var isWorking = false

            override fun onClick(v: View) {
                if (!isWorking) {
                    binding.chronometer.start()
                    isWorking = true
                } else {
                    binding.chronometer.stop()
                    isWorking = false
                }

                binding.btnChronometer.setText(if (isWorking) R.string.start else R.string.stop)

                Toast.makeText(
                    activity, getString(
                        if (isWorking)
                            R.string.working
                        else
                            R.string.stopped
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun dynamicChronometer() {
        // create the chronometer from XML file
        val meter = Chronometer(this)
        // set color and size of the text
        meter.setTextColor(Color.BLUE)
        meter.setTextSize(TypedValue.COMPLEX_UNIT_IN, 0.25f)


        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams.setMargins(30, 40, 120, 40)
        meter.layoutParams = layoutParams


        binding.root3?.addView(meter)

        //access the button using id
        binding.btnChronometerDynamic?.setOnClickListener(object : View.OnClickListener {

            var isWorking = false

            override fun onClick(v: View) {
                if (!isWorking) {
                    meter.start()
                    isWorking = true
                } else {
                    meter.stop()
                    isWorking = false
                }

                binding.btnChronometerDynamic.setText(if (isWorking) R.string.start else R.string.stop)

                Toast.makeText(
                    activity, getString(
                        if (isWorking)
                            R.string.working
                        else
                            R.string.stopped
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    @SuppressLint("RemoteViewLayout")
    fun notification() {
// accessing button

        // it is a class to notify the user of events that happen.
        // This is how you tell the user that something has happened in the
        // background.
        // onClick listener for the button
        binding.btnSendNotification.setOnClickListener {

            // pendingIntent is an intent for future use i.e after
            // the notification is clicked, this intent will come into action
            val intent = Intent(this, MainActivity::class.java)

            // FLAG_UPDATE_CURRENT specifies that if a previous
            // PendingIntent already exists, then the current one
            // will update it with the latest intent
            // 0 is the request code, using it later with the
            // same method again will get back the same pending
            // intent for future reference
            // intent passed here is to our afterNotification class
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            // RemoteViews are used to use the content of
            // some different layout apart from the current activity layout
            val contentView = RemoteViews(packageName, R.layout.activity_main)

            // checking if android version is greater than oreo(API 26) or not
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_background
                        )
                    )
                    .setContentIntent(pendingIntent)
            } else {

                builder = Notification.Builder(this)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_background
                        )
                    )
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, builder.build())
        }
    }

    fun sidUpDown() {
//setting buttons onClickListener
        binding.btnSlideDown.setOnClickListener {
            //adding our custom made animation xml file
            val animation = AnimationUtils.loadAnimation(
                this, R.anim.fade_out
            )
            //appending animation to textView
            binding.txtSlide.startAnimation(animation)
        }
        binding.btnSlideUp.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(
                this, R.anim.fade_in
            )
            binding.txtSlide.startAnimation(animation)
        }
    }

}