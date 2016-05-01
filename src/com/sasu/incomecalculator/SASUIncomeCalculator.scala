package com.sasu.incomecalculator

class SASUIncomeCalculator {

  def calculate(multiFreelanceCriterias: List[FreelanceCriterias]): List[Income] = {
    multiFreelanceCriterias match {
      case fc :: xs =>
        val dividend = new Dividend(fc)
        val incomeTax = new TotalIncomeTax(dividend, fc.salary).value
        Income(fc, fc.annualSalary + dividend.afterCSG - incomeTax) :: calculate(xs)
      case Nil =>  Nil
    }
  }

}
