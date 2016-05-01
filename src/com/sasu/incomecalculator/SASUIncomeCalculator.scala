package com.sasu.incomecalculator

class SASUIncomeCalculator {

  def calculate(multiFreelanceCriterias: List[FreelanceCriterias]): List[Income] = {
    multiFreelanceCriterias match {
      case fc :: xs => val salary = new Salary(fc.monthlySalaryAmount)
        val dividend = new Dividend(fc.freelanceCost, fc.charges, salary)
        val incomeTax = new TotalIncomeTax(dividend, salary).value
        Income(fc, salary.annualSalary + dividend.afterCSG - incomeTax) :: calculate(xs)
      case Nil =>  Nil
    }
  }

}
