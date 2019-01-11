package com.fabricio.altamirano.loans.commons

import com.fabricio.altamirano.loans.R

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class DataSample{
    fun loadData():ArrayList<Loan>{
        val array = ArrayList<Loan>()

        var loan = Loan()
        loan.tipo ="Préstamo Personal"
        loan.entity ="Santander consumer"
        loan.n_cuotas = 18
        loan.cuota = 337.98
        loan.importe = 5675.44
        loan.amortizado = 1196.28
        loan.id_image = R.drawable.ic_consumer

        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Personal"
        loan.entity ="Zaplo"
        loan.n_cuotas = 24
        loan.cuota = 211.48
        loan.importe = 4600.0
        loan.amortizado = 1940.76
        loan.id_image = R.drawable.ic_zaplo

        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Coche"
        loan.entity ="Sabadell"
        loan.n_cuotas = 24
        loan.cuota = 230.37
        loan.importe = 5045.22
        loan.amortizado = 197.76
        loan.id_image = R.drawable.ic_sabadell

        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Coche"
        loan.entity ="Cetelem"
        loan.n_cuotas = 60
        loan.cuota = 505.89
        loan.importe = 24375.98
        loan.amortizado = 2125.44
        loan.id_image = R.drawable.ic_cetelem

        array.add(loan)

        return array
    }
}