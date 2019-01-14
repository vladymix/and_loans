package com.fabricio.altamirano.loans.commons

import java.util.*

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class Loan {

    var importe: Double = 0.0
    var cuota: Double = 0.0
    var n_cuotas: Int = 0
    var n_cuotas_pagadas: Int = 0
    var amortizado: Double = 0.0
    var pendiente: Double = 0.0
    var id_image: Int = 0
    var interes: Double = 0.0 // 100%
    var interes_mes: Double = 0.0 // 100%

    lateinit var entity: String
    lateinit var tipo: String
    lateinit var date_start: Date
    lateinit var listBreakDownLoan: ArrayList<BreakDownLoan>
}