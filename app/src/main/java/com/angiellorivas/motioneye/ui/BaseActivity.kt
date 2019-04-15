package com.angiellorivas.motioneye.ui

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.children
import com.angiellorivas.motioneye.R
import java.io.IOException


/**
 * @author sk8 on 7/03/19.
 */

abstract class BaseActivity: AppCompatActivity() {

    private var toolbarTitle: TextView? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = this.localClassName
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbar?.run {
            toolbarTitle = this.findViewById(R.id.toolbar_title)
            setSupportActionBar(this)
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        // Remove default title text
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun setToolbarTitle(@StringRes textResId: Int) {
        toolbarTitle?.setText(textResId)
    }

    fun setToolbarTitle(title: String) {
        toolbarTitle?.text = title
    }

    companion object{
        lateinit var TAG: String
    }
}