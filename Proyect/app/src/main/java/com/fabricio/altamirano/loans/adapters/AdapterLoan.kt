package com.fabricio.altamirano.loans.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.commons.DataSample
import com.fabricio.altamirano.loans.commons.Loan
import java.util.*

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class AdapterLoan(context: Context, source :ArrayList<Loan>) : BaseAdapter(){

    private var sList :ArrayList<Loan> = source

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Loan {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.item_loan, parent, false)
            vh = ViewHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        val loan =sList[position]

        vh.loadData(loan)

        return view
    }

}

private class ViewHolder(row: View?) {

    val tx_tipo: TextView
    val tx_entity: TextView
    val tx_importe: TextView
    val tx_n_cuotas: TextView
    val tx_cuota: TextView
    val tx_amortizado: TextView
    val tx_pendiente: TextView
    val progress_bar:ProgressBar
    val iv_logo: ImageView

    init {
        this.tx_tipo = row?.findViewById(R.id.tx_tipo) as TextView
        this.tx_entity = row.findViewById(R.id.tx_entity) as TextView
        this.tx_importe = row.findViewById(R.id.tx_importe) as TextView
        this.tx_n_cuotas = row.findViewById(R.id.tx_n_cuotas) as TextView
        this.tx_cuota = row.findViewById(R.id.tx_cuota) as TextView
        this.tx_amortizado = row.findViewById(R.id.tx_amortizado) as TextView
        this.tx_pendiente = row.findViewById(R.id.tx_pendiente) as TextView
        this.progress_bar = row.findViewById(R.id.progress_bar)
        this.iv_logo = row.findViewById(R.id.iv_logo)
    }

    fun loadData(loan: Loan) {
        loan.pendiente = loan.importe - loan.amortizado

        this.tx_tipo.text = loan.tipo
        this.tx_entity.text = loan.entity
        this.tx_importe.text = DataSample.geAsCoin(loan.importe)
        this.tx_cuota.text =  DataSample.geAsCoin(loan.cuota)
        this.tx_n_cuotas.text = loan.n_cuotas.toString()
        this.tx_amortizado.text = DataSample.geAsCoin(loan.amortizado)
        this.tx_pendiente.text = DataSample.geAsCoin(loan.pendiente)
        this.iv_logo.setImageResource(loan.id_image)

        // importe = 100%
        // pendiente = x
        // 200 = 100%
        // 50 = x%
        // x = 100% *50 / 200
        this.progress_bar.progress = (100 * loan.amortizado / loan.importe).toInt()


    }
}