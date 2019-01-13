package com.fabricio.altamirano.loans.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.commons.BreakDownLoan

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class AdapterBreakDownLoan(context: Context, source:ArrayList<BreakDownLoan>) : BaseAdapter() {
     var source:ArrayList<BreakDownLoan>
    private val mInflator: LayoutInflater

    init{
        this.source = source;
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolderBreak
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.item_breakdown_loan, parent, false)
            vh = ViewHolderBreak(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolderBreak
        }

        val loan =source[p0];

        vh.loadData(loan);

        return view
    }

    override fun getItem(p0: Int): BreakDownLoan {
       return this.source[p0]
    }

    override fun getItemId(p0: Int): Long {
        return  p0.toLong();
    }

    override fun getCount(): Int {
      return source.size
    }
}

private class ViewHolderBreak(row: View?) {

    private var tv_n_cuota: TextView
    private var tv_fecha: TextView
    private var tv_cuota: TextView
    private var tv_capital_amortizado: TextView
    private var tv_capital_pendiente: TextView
    private var tv_intereses: TextView

    init{
        tv_n_cuota = row?.findViewById(R.id.tv_n_cuota) as TextView
        tv_fecha = row?.findViewById(R.id.tv_fecha) as TextView
        tv_cuota = row?.findViewById(R.id.tv_cuota) as TextView
        tv_capital_amortizado = row?.findViewById(R.id.tv_capital_amortizado) as TextView
        tv_capital_pendiente = row?.findViewById(R.id.tv_capital_pendiente) as TextView
        tv_intereses = row?.findViewById(R.id.tv_intereses) as TextView
    }

    fun loadData(breakDown: BreakDownLoan) {
        this.tv_n_cuota.text = breakDown.n_cuota.toString()
        this.tv_cuota.text = breakDown.cuota.toString()
        this.tv_capital_amortizado.text = breakDown.cuota_amortizacion.toString()
        this.tv_capital_pendiente.text = breakDown.pendiente.toString()
        this.tv_intereses.text = breakDown.intereses.toString()
    }
}