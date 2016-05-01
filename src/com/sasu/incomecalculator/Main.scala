package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multiFreelanceCriterias = List(
      FreelanceCriterias(500, 8000, 2500),
      FreelanceCriterias(500, 8000, 2500),
      FreelanceCriterias(500, 8000, 2500)
    )
    val incomes = new SASUIncomeCalculator().calculate(multiFreelanceCriterias)
    new IncomeDisplay(incomes).display()
  }

}
