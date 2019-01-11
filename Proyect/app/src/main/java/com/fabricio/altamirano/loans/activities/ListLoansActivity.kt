package com.fabricio.altamirano.loans.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.adapters.AdapterLoan
import com.fabricio.altamirano.loans.commons.DataSample
import com.fabricio.altamirano.loans.commons.Loan
import kotlinx.android.synthetic.main.activity_list_loans.*

class ListLoansActivity : AppCompatActivity() {

    lateinit var adapter:AdapterLoan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_loans)
        lv_loans.emptyView = ly_empty

       var dataSample= DataSample()

        adapter = AdapterLoan(this, dataSample.loadData())
        lv_loans.adapter = adapter
    }
}
