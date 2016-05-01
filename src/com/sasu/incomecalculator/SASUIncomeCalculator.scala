package com.sasu.incomecalculator

class SASUIncomeCalculator {

  def calculate(freelanceCosts: List[Int], costs: Double, monthlySalary: Double): List[Income] = {
    freelanceCosts match {
      case fc :: xs => val salary = new Salary(monthlySalary)
        val dividend = new Dividend(fc, costs, salary)
        val incomeTax = new TotalIncomeTax(dividend, salary).value
        Income(fc, salary.annualSalary + dividend.afterCSG - incomeTax) :: calculate(xs, costs, monthlySalary)
      case Nil =>  Nil
    }
  }

}
