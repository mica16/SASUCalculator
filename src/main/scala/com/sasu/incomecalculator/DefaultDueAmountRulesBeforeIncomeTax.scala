package com.sasu.incomecalculator

class DefaultDueAmountRulesBeforeIncomeTax(taxSocietyAmount: TaxSocietyAmount) extends DueAmountRulesBeforeIncomeTax{
  val salaryCostFn: Float => Float  = _ * 89 / 100
  val taxSocietyFn: Float => Float = taxSocietyAmount.calculate
  val CSGFn: Float => Float = _ * 15.5f / 100
}
