package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multipleFreelanceCriteria = List(
      FreelanceCriteria(turnover = 35000, fees = 8000, monthlySalary = 1000)
    )
    val incomes = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(new DefaultTaxSocietyAmount),
      new DefaultIncomeTaxRules(new DefaultTaxIncomeAmount)).calculate(multipleFreelanceCriteria)
    println(new IncomesFormatter().format(incomes))
  }

}

