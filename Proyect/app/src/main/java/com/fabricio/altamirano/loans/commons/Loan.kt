package com.fabricio.altamirano.loans.commons

import java.util.*

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class Loan {

    var entity: String = ""
    var tipo: String = ""
    var importe: Double = 0.0
    var cuota: Double = 0.0
    var n_cuotas: Int = 0
    var n_cuotas_pagadas: Int = 0
    var amortizado: Double = 0.0
    var pendiente: Double = 0.0
    var id_image: Int = 0
    var interes: Double = 0.0 // 100%
    var interes_mes: Double = 0.0 // 100%
    lateinit var date_start:Date;

    fun loadBrakingDownLoan(): ArrayList<BreakDownLoan> {

        val array = ArrayList<BreakDownLoan>()

        this.interes_mes = this.interes / 12

        this.cuota = this.importe * this.interes_mes / ((1 - Math.pow((1 + this.interes_mes / 100), this.n_cuotas * (-1.0))) * 100)

        var resto = this.importe

        for (i in 1..this.n_cuotas) {

            val breakDown = BreakDownLoan()
            breakDown.n_cuota = i;
            breakDown.cuota = this.cuota
            breakDown.intereses = resto * (this.interes_mes / 100)
            breakDown.cuota_amortizacion = breakDown.cuota - breakDown.intereses
            breakDown.pendiente = resto - breakDown.cuota_amortizacion;
            resto = breakDown.pendiente
            array.add(breakDown)
        }

        return array
    }

}