package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val IncomesCalculator = new SASUIncomeCalculator
    val freelanceCosts = List(500, 550, 600)
    val incomes = IncomesCalculator.calculate(freelanceCosts, 8000, 2500)
    new IncomeDisplay(incomes).display()
  }

}
