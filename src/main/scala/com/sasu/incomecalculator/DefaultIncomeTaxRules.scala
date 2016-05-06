package com.sasu.incomecalculator

class DefaultIncomeTaxRules(taxIncomeAmount: TaxIncomeAmount) extends IncomeTaxRules {
  val dividendDroopFn: Float => Float = _ * 60 / 100
  val CSGFn: Float => Float = _ * 5.1f / 100
  val taxSalaryFn: Float => Float = _ * 90 / 100
  val taxIncomeFn: Float => Float = taxIncomeAmount.calculate
}
