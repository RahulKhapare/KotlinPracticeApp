package com.rak_developer.kotlinpracticeapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityQuotesViewModelBinding
import com.rak_developer.kotlinpracticeapp.model.QuotesModel
import com.rak_developer.kotlinpracticeapp.model.QuotesModelFactory
import com.rak_developer.kotlinpracticeapp.model.QuotesViewModel

class QuotesViewModelActivity : AppCompatActivity(), View.OnClickListener {

    val activity = this@QuotesViewModelActivity;
    lateinit var binding: ActivityQuotesViewModelBinding
    lateinit var quotesViewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quotes_view_model);
        quotesViewModel = ViewModelProvider(
            this,
            QuotesModelFactory(application)
        ).get(QuotesViewModel::class.java)
        init()
    }

    fun init() {
        (this@QuotesViewModelActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Quotes App"

        setQuotes(quotesViewModel.getQuotes())

        binding.btnShare?.setOnClickListener(activity)
        binding.btnPrev?.setOnClickListener(activity)
        binding.btnNext?.setOnClickListener(activity)
    }

    fun setQuotes(quotesModel: QuotesModel) {
        binding.txtQuotes.text = quotesModel.text;
        binding.txtAuthor.text = quotesModel.author;
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnShare -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, quotesViewModel.getQuotes().text);
                startActivity(Intent.createChooser(shareIntent, "Send to.."))
            }
            R.id.btnPrev -> {
                setQuotes(quotesViewModel.previousQuotes())
            }
            R.id.btnNext -> {
                setQuotes(quotesViewModel.nextQuotes())
            }
        }
    }

}