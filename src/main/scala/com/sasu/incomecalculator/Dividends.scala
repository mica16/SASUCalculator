package com.sasu.incomecalculator

class Dividends(turnover: Float, fees: Float,
                annualSalary: AnnualSalary,
                taxSocietyFn: Float => Float,
                CSGAfterIsFn: Float => Float,
                CSGAboutIncomeTaxFn: Float => Float,
                dividendDroopFn: Float => Float) extends Taxable {

  private val initialAmount = turnover - fees - annualSalary.amount - annualSalary.cost

  lazy val afterTaxSociety = {
    initialAmount - taxSocietyFn(initialAmount)
  }

  lazy val afterCSG = {
    afterTaxSociety  - CSGAfterIsFn(afterTaxSociety)
  }

  def taxAmount = {
    dividendDroopFn(afterCSG) - CSGAboutIncomeTaxFn(afterTaxSociety)
  }

}
