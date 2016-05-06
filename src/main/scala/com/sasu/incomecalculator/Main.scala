package com.sasu.incomecalculator

object Main {

  def main(args: Array[String]) {
    val list = List((80000f, 8000f, 2500f), (116600f, 8000f, 3000f))
    val incomes = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(new DefaultTaxSocietyAmount),
      new DefaultIncomeTaxRules(new DefaultTaxIncomeAmount)).calculateM(list)
    println(incomes)
  }

}
