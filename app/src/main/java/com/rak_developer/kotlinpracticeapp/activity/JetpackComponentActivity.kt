package com.rak_developer.kotlinpracticeapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityJetpackComponentBinding

class JetpackComponentActivity : AppCompatActivity(), View.OnClickListener {

    val activity = this@JetpackComponentActivity;
    lateinit var binding: ActivityJetpackComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_jetpack_component);
        init()
    }

    fun init() {
        (this@JetpackComponentActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Jetpack Architecture Component"

        binding.btnLifecycleAware?.setOnClickListener(activity)
        binding.btnViewModel?.setOnClickListener(activity)
        binding.btnViewModelApp?.setOnClickListener(activity)
        binding.btnLiveData?.setOnClickListener(activity)
        binding.btnDataBinding1?.setOnClickListener(activity)
        binding.btnDataBinding2?.setOnClickListener(activity)
        binding.btnDataBinding3?.setOnClickListener(activity)
        binding.btnMVVMArchitectureDB?.setOnClickListener(activity)
        binding.btnListAdapter?.setOnClickListener(activity)
        binding.btnRecyclerAdapter?.setOnClickListener(activity)
        binding.btnMVVMRetrofitCoroutinesAndDBAndWorkManagerAndError?.setOnClickListener(activity)
        binding.btnPaging?.setOnClickListener(activity)
        binding.btnNavigation?.setOnClickListener(activity)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLifecycleAware -> {
                intent = Intent(activity, LifecycleAwareActivity::class.java)
                startActivity(intent)
            }
            R.id.btnViewModel -> {
                intent = Intent(activity, ViewModelActivity::class.java)
                startActivity(intent)
            }
            R.id.btnViewModelApp -> {
                intent = Intent(activity, QuotesViewModelActivity::class.java)
                startActivity(intent)
            }
            R.id.btnLiveData -> {
                intent = Intent(activity, LiveDataActivity::class.java)
                startActivity(intent)
            }
            R.id.btnDataBinding1 -> {
                intent = Intent(activity, DataBindingActivity::class.java)
                startActivity(intent)
            }
            R.id.btnDataBinding2 -> {
                intent = Intent(activity, DataBindingWithLiveDataActivity::class.java)
                startActivity(intent)
            }
            R.id.btnDataBinding3 -> {
                intent = Intent(activity, DataBindingAdapterActivity::class.java)
                startActivity(intent)
            }
            R.id.btnRoomDatabase -> {
                intent = Intent(activity, RoomDatabaseActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMVVMArchitectureDB -> {
                intent = Intent(activity, MVVMArchitectureWithDBActivity::class.java)
                startActivity(intent)
            }
            R.id.btnListAdapter -> {
                intent = Intent(activity, ListAdapterWithDiffUtilActivity::class.java)
                startActivity(intent)
            }
            R.id.btnRecyclerAdapter -> {
                intent =
                    Intent(activity, RecyclerAdapaterWithAndWithoughtBindingActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMVVMRetrofitCoroutinesAndDBAndWorkManagerAndError -> {
                intent =
                    Intent(activity, MVVMRetrofitWithCoroutinesAndDatabaseActivity::class.java)
                startActivity(intent)
            }
            R.id.btnPaging -> {
                intent =
                    Intent(activity, PagingActivity::class.java)
                startActivity(intent)
            }
            R.id.btnNavigation -> {
                intent =
                    Intent(activity, NavigationComponentActivity::class.java)
                startActivity(intent)
            }

        }
    }
}

