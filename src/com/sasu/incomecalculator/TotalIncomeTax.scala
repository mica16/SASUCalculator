package com.sasu.incomecalculator

class TotalIncomeTax(dividend: Dividend, freelanceCriteria: FreelanceCriteria) {

  def value: Double = {
    val taxSum = dividend.incomeTax + freelanceCriteria.incomeTax
    val rankIntervalsList = List[(Double,Double,Double)]((0, 9700, 0), (9700, 26791, 14), (26792, 71826, 30),
      (71826, 152108, 41), (152108, Double.MaxValue, 45))
    TaxRankCalculator.calculate(taxSum, rankIntervalsList)
  }

}
