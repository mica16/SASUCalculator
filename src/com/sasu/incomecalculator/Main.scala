package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multiFreelanceCriteria = List(
      new FreelanceCriteria(500, 212, 8000, Salary(2500)),
      new FreelanceCriteria(520, 212, 8000, Salary(2500)),
      new FreelanceCriteria(550, 212, 8000, Salary(2500)),
      new FreelanceCriteria(600, 212, 15000, Salary(2500)),
      new FreelanceCriteria(800, 212, 8000, Salary(2500))
      //new FreelanceCriteria(500, 212, 8000, Salary(2500))
      //new FreelanceCriteria(333.33, 240, 8000, Salary(2500))
    )
    val incomes = new SASUIncomeCalculator().calculate(multiFreelanceCriteria)
    new IncomeDisplay(incomes).display()
  }

}
