package com.fabricio.altamirano.loans.commons

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class Loan {
    lateinit var entity :String
    lateinit var tipo :String
    var importe: Double = 0.0

    var cuota : Double =0.0
    var n_cuotas :Int =0

    var amortizado: Double = 0.0
    var pendiente : Double =0.0

}