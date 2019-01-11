package com.fabricio.altamirano.loans.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.fabricio.altamirano.loans.R
import com.fabricio.altamirano.loans.commons.Loan
import java.util.ArrayList

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
public class AdapterLoan(context: Context, source :ArrayList<Loan>) : BaseAdapter(){

    private var sList :ArrayList<Loan>

    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)
        this.sList = source;
    }

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
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
        var loan =sList[position];

        vh.loadData(loan);

        return view
    }

}

private class ViewHolder(row: View?) {

    fun loadData(loan: Loan) {
        loan.pendiente = loan.importe - loan.amortizado

        tx_tipo.text = loan.tipo
        tx_entity.text = loan.entity
        tx_importe.text = loan.importe.toString()
        tx_cuota.text =  loan.cuota.toString()
        tx_n_cuotas.text = loan.n_cuotas.toString()
        this.tx_amortizado.text = loan.amortizado.toString()
        this.tx_pendiente.text = loan.pendiente.toString()



        // importe = 100%
        // pendiente = x
        // 200 = 100%
        // 50 = x%
        // x = 100% *50 / 200

        // pendiente =  importe - amortizado
        this.progress_bar.progress = (100 * loan.amortizado / loan.importe).toInt()


    }

    public val tx_tipo: TextView
    public val tx_entity: TextView
    public val tx_importe: TextView
    public val tx_n_cuotas: TextView
    public val tx_cuota: TextView

    public val tx_amortizado: TextView
    public val tx_pendiente: TextView
    public val progress_bar:ProgressBar

    init {
        this.tx_tipo = row?.findViewById(R.id.tx_tipo) as TextView
        this.tx_entity = row?.findViewById(R.id.tx_entity) as TextView
        this.tx_importe = row?.findViewById(R.id.tx_importe) as TextView
        this.tx_n_cuotas = row?.findViewById(R.id.tx_n_cuotas) as TextView
        this.tx_cuota = row?.findViewById(R.id.tx_cuota) as TextView
        this.tx_amortizado =row?.findViewById(R.id.tx_amortizado) as TextView
        this.tx_pendiente =row?.findViewById(R.id.tx_pendiente) as TextView
        this.progress_bar = row?.findViewById(R.id.progress_bar)
    }
}