package com.fabricio.altamirano.loans.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.adapters.AdapterBreakDownLoan
import com.fabricio.altamirano.loans.commons.DataSample
import kotlinx.android.synthetic.main.content_details.*

class BreakDownDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_break_down_details)

        listview_breakdown.adapter = AdapterBreakDownLoan(this, DataSample.details.loadBrakingDownLoan())
    }
}
