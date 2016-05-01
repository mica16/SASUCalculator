package com.sasu.incomecalculator

case class Income(freelanceCost: Int, annualIncome: Double) {

  val monthlyIncome = annualIncome / 12

}
