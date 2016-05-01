package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multiFreelanceCriteria = List(
      new FreelanceCriteria(500, 212, 3000, Salary(2500)),
      new FreelanceCriteria(500, 212, 4000, Salary(2500)),
      new FreelanceCriteria(500, 212, 6000, Salary(2500)),
      new FreelanceCriteria(500, 212, 6000, Salary(2500)),
      new FreelanceCriteria(3333.33, 240, 8000, Salary(2500))
    )
    val incomes = new SASUIncomeCalculator().calculate(multiFreelanceCriteria)
    new IncomeDisplay(incomes).display()
  }

}
