package com.fabricio.altamirano.loans.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.adapters.AdapterLoan
import com.fabricio.altamirano.loans.commons.DataSample
import com.fabricio.altamirano.loans.commons.Loan
import kotlinx.android.synthetic.main.activity_list_loans.*

class ListLoansActivity : AppCompatActivity() {

    lateinit var adapter: AdapterLoan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_loans)

        val dataSample = DataSample()

        this.adapter = AdapterLoan(this, dataSample.loadData())

        this.lv_loans.emptyView = ly_empty

        this.lv_loans.adapter = adapter

        this.lv_loans.setOnItemClickListener { adapterView, view, i, l -> navigateToBreakDownDetails(adapter.getItem(i))}
    }

    fun navigateToBreakDownDetails(selected:Loan){
        DataSample.details = selected
        val intent = Intent(this, BreakDownDetailsActivity::class.java)
        startActivity(intent)
    }
}
