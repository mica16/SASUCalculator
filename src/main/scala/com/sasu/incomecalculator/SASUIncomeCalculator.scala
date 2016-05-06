package com.sasu.incomecalculator

case class Income(turnover: Float, fees: Float, monthlySalary: Float, amount: Float)

class SASUIncomeCalculator(dueAmountRulesBeforeIncomeTax: DueAmountRulesBeforeIncomeTax,
                           defaultIncomeTaxRules: IncomeTaxRules) {

  def calculateM(criteria: List[(Float, Float, Float)]): List[Income] = {
    criteria match {
      case c :: xs =>
        calculate(c._1, c._2, c._3) :: calculateM(xs)
      case Nil => Nil
    }
  }

  def calculate(turnover: Float, fees: Float, monthlySalary: Float) = {
    val annualSalary = new AnnualSalary(monthlySalary, dueAmountRulesBeforeIncomeTax.salaryCostFn, defaultIncomeTaxRules.taxSalaryFn)
    val dividends = new Dividends(turnover, fees, annualSalary, dueAmountRulesBeforeIncomeTax.taxSocietyFn,
      dueAmountRulesBeforeIncomeTax.CSGFn, defaultIncomeTaxRules.CSGFn, defaultIncomeTaxRules.dividendDroopFn)
    val taxes = defaultIncomeTaxRules.taxIncomeFn(dividends.taxAmount + annualSalary.taxAmount)
    Income(turnover, fees, monthlySalary, (annualSalary.amount + dividends.afterCSG - taxes).round)
  }

}
