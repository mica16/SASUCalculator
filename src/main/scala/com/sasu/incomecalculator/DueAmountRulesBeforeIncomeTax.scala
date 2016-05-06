package com.sasu.incomecalculator

trait DueAmountRulesBeforeIncomeTax {
  val salaryCostFn: Float => Float
  val taxSocietyFn: Float => Float
  val CSGFn: Float => Float
}
