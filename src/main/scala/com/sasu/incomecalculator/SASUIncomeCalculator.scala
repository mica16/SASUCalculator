package com.sasu.incomecalculator

case class Income(turnover: Float, fees: Float, monthlySalary: Float, amount: Float)

class SASUIncomeCalculator(dueAmountRulesBeforeIncomeTax: DueAmountRulesBeforeIncomeTax,
                           defaultIncomeTaxRules: IncomeTaxRules) {

  def calculate(freelanceCriteria: List[FreelanceCriteria]): List[Income] = {
    freelanceCriteria match {
      case fc :: xs =>
        val annualSalary = new AnnualSalary(fc.monthlySalary, dueAmountRulesBeforeIncomeTax.salaryCostFn, defaultIncomeTaxRules.taxSalaryFn)
        val dividends = new Dividends(fc.turnover, fc.fees, annualSalary, dueAmountRulesBeforeIncomeTax.taxSocietyFn,
          dueAmountRulesBeforeIncomeTax.CSGFn, defaultIncomeTaxRules.CSGFn, defaultIncomeTaxRules.dividendDroopFn)
        val taxes = defaultIncomeTaxRules.taxIncomeFn(dividends.taxAmount + annualSalary.taxAmount)
        Income(fc.turnover, fc.fees, fc.monthlySalary, (annualSalary.amount + dividends.afterCSG - taxes).round) :: calculate(xs)
      case Nil => Nil
    }
  }

}
