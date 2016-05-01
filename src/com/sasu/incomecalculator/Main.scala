package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multiFreelanceCriterias = List(
      FreelanceCriterias(500, 240, 3000, Salary(2500)),
      FreelanceCriterias(500, 240, 4000, Salary(2500)),
      FreelanceCriterias(500, 240, 6000, Salary(2500)),
      FreelanceCriterias(333.33, 240, 8000, Salary(2500))
    )
    val incomes = new SASUIncomeCalculator().calculate(multiFreelanceCriterias)
    new IncomeDisplay(incomes).display()
  }

}
