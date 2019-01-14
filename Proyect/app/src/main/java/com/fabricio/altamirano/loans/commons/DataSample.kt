package com.fabricio.altamirano.loans.commons

import android.text.format.DateFormat
import android.util.Log
import com.fabricio.altamirano.loans.R
import java.util.*
import java.util.logging.SimpleFormatter

/**
 * Created by fabricio Altamirano on 11/01/2019.
 */
class DataSample{

    companion object {
        var details = Loan()
        fun geAsCoin(value:Double, symbol:String):String {

            var str = String.format("%.2f", value)
            str += symbol
            return str
        }
        fun geAsCoin(value:Double):String {
            return geAsCoin(value,"€")
        }

        fun getDate(dateLoan: Date): String {
          return  DateFormat.format("dd/MM/yyyy", dateLoan).toString()
        }
    }


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
        loan.interes = 8.8766
        loan.date_start = getDate(1,10,2018)
        updateData(loan)

        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Personal"
        loan.entity ="Zaplo"
        loan.n_cuotas = 24
        loan.cuota = 211.48
        loan.importe = 4600.0
        loan.amortizado = 1940.76
        loan.id_image = R.drawable.ic_zaplo
        loan.interes = 9.63
        loan.date_start = getDate(1,5,2018)
        updateData(loan)
        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Coche"
        loan.entity ="Sabadell"
        loan.n_cuotas = 24
        loan.cuota = 230.37
        loan.importe = 5045.22
        loan.amortizado = 197.76
        loan.id_image = R.drawable.ic_sabadell
        loan.interes = 8.95
        loan.date_start = getDate(1,1,2019)
        updateData(loan)
        array.add(loan)

        loan = Loan()
        loan.tipo ="Préstamo Coche"
        loan.entity ="Cetelem"
        loan.n_cuotas = 60
        loan.cuota = 505.89
        loan.importe = 24375.98
        loan.amortizado = 2125.44
        loan.id_image = R.drawable.ic_cetelem
        loan.interes = 8.99
        loan.date_start = getDate(5,8,2018)
        updateData(loan)
        array.add(loan)

        return array
    }

    fun updateData(loan:Loan){
        val dateStart = loan.date_start
        val currentData = Calendar.getInstance().time
        var numerMonths = numberMonths(dateStart, currentData)

        Log.i("DataSample meses",numerMonths.toString() )

        val array = loadBrakingDownLoan(loan)
        loan.listBreakDownLoan = array
        loan.n_cuotas_pagadas = numerMonths

        var amortizado:Double=0.0
        for(i in 0..numerMonths-1){
            val item = array[i]
            amortizado += item.cuota_amortizacion
        }
        loan.amortizado = amortizado
    }

    fun numberMonths(dateStart:Date, dateEnd:Date):Int{

        val calendarStart = Calendar.getInstance()
        calendarStart.time = dateStart
        val diaStart =  calendarStart.get(Calendar.DAY_OF_MONTH)
        val mesStart =  calendarStart.get(Calendar.MONTH)
        val yearStart =  calendarStart.get(Calendar.YEAR)

        val calendarEnd =Calendar.getInstance()
        calendarEnd.time = dateEnd
        val diaEnd =  calendarEnd.get(Calendar.DAY_OF_MONTH)
        val mesEnd =  calendarEnd.get(Calendar.MONTH)
        val yearEnd =  calendarEnd.get(Calendar.YEAR)

        var include =0

        if(diaStart <= diaEnd){
            include = 1
        }
        // 1 - 10 = -9
        // 2019 - 2018 = 1 * 12
       // 12 -9 = 3
        // 10 - 4
        return  (mesEnd+1) - (mesStart+1) + (12 * (yearEnd - yearStart)) + include
    }

    fun getDate(dia:Int, mes:Int, year:Int):Date{
        val calendar =Calendar.getInstance()
        calendar.set(Calendar.YEAR,year)
        calendar.set(Calendar.MONTH,mes-1)
        calendar.set(Calendar.DAY_OF_MONTH, dia)
        return  calendar.time
    }

    fun loadBrakingDownLoan(loan: Loan): ArrayList<BreakDownLoan>{
        val array = ArrayList<BreakDownLoan>()
        val dateStart = loan.date_start
        val cl = Calendar.getInstance()
        cl.time = dateStart;

        loan.interes_mes = loan.interes / 12

        loan.cuota = loan.importe * loan.interes_mes / ((1 - Math.pow((1 + loan.interes_mes / 100), loan.n_cuotas * (-1.0))) * 100)

        var resto = loan.importe

        for (i in 1..loan.n_cuotas) {
            val breakDown = BreakDownLoan()
            if (i != 1) {
                cl.add(Calendar.MONTH, 1)
            }
            breakDown.n_cuota = i;
            breakDown.dateLoan = cl.time
            breakDown.cuota = loan.cuota
            breakDown.intereses = resto * (loan.interes_mes / 100)
            breakDown.cuota_amortizacion = breakDown.cuota - breakDown.intereses
            breakDown.pendiente = resto - breakDown.cuota_amortizacion;
            resto = breakDown.pendiente
            array.add(breakDown)
        }

        return array
    }

}