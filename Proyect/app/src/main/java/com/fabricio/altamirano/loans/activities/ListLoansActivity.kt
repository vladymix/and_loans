package com.fabricio.altamirano.loans.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.adapters.AdapterLoan
import com.fabricio.altamirano.loans.commons.DataSample
import kotlinx.android.synthetic.main.activity_list_loans.*

class ListLoansActivity : AppCompatActivity() {

    lateinit var adapter: AdapterLoan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_loans)

        lv_loans.emptyView = ly_empty

        var dataSample = DataSample()

        adapter = AdapterLoan(this, dataSample.loadData())
        lv_loans.adapter = adapter

        lv_loans.setOnItemClickListener { adapterView, view, i, l ->

            var item = adapter.getItem(i)
            var array = item.loadBrakingDownLoan();

            DataSample.details = item
            val intent = Intent(this, BreakDownDetailsActivity::class.java)
            startActivity(intent)

        }
    }
}
