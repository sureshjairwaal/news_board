package com.example.ap_assignmen.ui.home.activities

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.ap_assignmen.BuildConfig
import com.example.ap_assignmen.R
import com.example.ap_assignmen.databinding.ActivityNewsBinding
import com.example.ap_assignmen.ui.home.adapters.AdapterNews
import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import com.example.ap_assignmen.ui.home.viewmodels.MediaCoverageViewModel


class ActivityNews : AppCompatActivity() {
    private val TAG = this.javaClass.canonicalName
    private lateinit var binding: ActivityNewsBinding
    private var items: MutableList<ModelNewsArticles.Article> = mutableListOf()
    private val viewModel by lazy {
        ViewModelProvider(this)[MediaCoverageViewModel::class.java]
    }
    private val adapterNews by lazy {
        AdapterNews(items) {
            Toast.makeText(
                this@ActivityNews,
                getString(R.string.functionality_not_implemented_yet),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initView()
    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.news)
    }

    private fun initView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            adapter = adapterNews
        }
        viewModel.mediaCoveragesList.observe(this) {
            items.addAll(it)
            adapterNews.notifyItemRangeInserted(0, items.size)
        }
        if (BuildConfig.API_KEY == "API_KEY"){
            val dialog = AlertDialog.Builder(this)
            dialog.setCancelable(false)
            dialog.setMessage(getString(R.string.api_key_message))
            dialog.show()
            return
        }
        viewModel.initData()
    }
}