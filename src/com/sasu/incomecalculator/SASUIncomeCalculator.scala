package com.sasu.incomecalculator

class SASUIncomeCalculator {

  def calculate(multiFreelanceCriteria: List[FreelanceCriteria]): List[Income] = {
    multiFreelanceCriteria match {
      case fc :: xs =>
        val dividend = new Dividend(fc)
        val incomeTax = new TotalIncomeTax(dividend, fc.salary).value
        Income(fc, fc.annualSalary + dividend.afterCSG - incomeTax) :: calculate(xs)
      case Nil =>  Nil
    }
  }

}
