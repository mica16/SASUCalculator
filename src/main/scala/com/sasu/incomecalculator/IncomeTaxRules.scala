package com.sasu.incomecalculator

trait IncomeTaxRules {
  val dividendDroopFn: Float => Float
  val CSGFn: Float => Float
  val taxSalaryFn: Float => Float
  val taxIncomeFn: Float => Float
}

class DefaultTaxSocietyAmount extends TaxSocietyAmount {
  def calculate(dividendsInitialAmount: Float): Float = {
    val rankIntervalsList = List[(Float,Float,Float)]((0, 38120, 15), (38120, Float.MaxValue, 33.33f))
    println("tax society: " + dividendsInitialAmount)
    TaxRankCalculator.calculate(dividendsInitialAmount, rankIntervalsList)
  }
}

class DefaultTaxIncomeAmount extends TaxIncomeAmount {
  def calculate(taxIncomeAmount: Float): Float = {
    val rankIntervalsList = List[(Float,Float,Float)]((0, 9700, 0f), (9700, 26791, 14f), (26792, 71826, 30f),
      (71826, 152108f, 41f), (152108, Float.MaxValue, 45f))
    println("tax income: " + taxIncomeAmount)
    TaxRankCalculator.calculate(taxIncomeAmount, rankIntervalsList)
  }
}


