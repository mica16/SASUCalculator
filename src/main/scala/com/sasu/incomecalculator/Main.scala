package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val multipleFreelanceCriteria = List(
      FreelanceCriteria(priceByDay = 350, nbYearlyWorkedDays = 212, fees = 8000, monthlySalary = 3000),
      FreelanceCriteria(priceByDay = 400, nbYearlyWorkedDays = 212, fees = 8000, monthlySalary = 3000),
      FreelanceCriteria(priceByDay = 530, nbYearlyWorkedDays = 212, fees = 8000, monthlySalary = 3000),
      FreelanceCriteria(priceByDay = 550, nbYearlyWorkedDays = 212, fees = 8000, monthlySalary = 2500)
    )
    val incomes = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(new DefaultTaxSocietyAmount),
      new DefaultIncomeTaxRules(new DefaultTaxIncomeAmount)).calculate(multipleFreelanceCriteria)
    println(new IncomesFormatter().format(incomes))
  }

}
