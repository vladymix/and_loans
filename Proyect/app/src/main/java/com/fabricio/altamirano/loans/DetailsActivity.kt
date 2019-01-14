package com.fabricio.altamirano.loans

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.fabricio.altamirano.loans.adapters.AdapterBreakDownLoan
import com.fabricio.altamirano.loans.commons.DataSample
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        listview_breakdown.adapter = AdapterBreakDownLoan(this,DataSample.details.listBreakDownLoan)
    }
}
