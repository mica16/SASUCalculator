package com.sasu.incomecalculator

class AnnualSalary(monthlySalary: Float, costFn: Float => Float, taxAmountFn: Float => Float) extends Taxable {

  lazy val amount = monthlySalary * 12

  lazy val cost = costFn(amount)

  def taxAmount: Float = {
    taxAmountFn(amount)
  }

}
