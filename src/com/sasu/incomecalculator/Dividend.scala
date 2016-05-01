package com.sasu.incomecalculator

class Dividend(freelanceCost: Int, costs: Double, salary: Salary) {

  val dividend = freelanceCost*20*12 - costs - salary.salaryCost

  private val afterIs = {
    val is = if (dividend <= 38120)
      dividend * 15 / 100
    else
      dividend * 33.33 / 100
    dividend - is
  }

  val afterCSG = afterIs - afterIs * 15.5 / 100

  val incomeTax = afterCSG * 60 / 100 - afterIs * 5.1 / 100

}

