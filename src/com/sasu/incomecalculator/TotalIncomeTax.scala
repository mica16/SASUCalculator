package com.sasu.incomecalculator

class TotalIncomeTax(dividend: Dividend, freelanceCriteria: FreelanceCriteria) {

  def value: Double = {
    val taxSum = dividend.incomeTax + freelanceCriteria.incomeTax
    val rankIntervalsList = List((0, 9700, 0), (9700, 26791, 14), (26792, 71826, 30),
      (71826, 152108, 41), (152108, Int.MaxValue, 45))

    rankIntervalsList.foldLeft(0d)((acc, value) => {
      if(taxSum <= value._1)
        return acc
      (if (taxSum >= value._2)
        value._2 - value._1
      else
        taxSum - value._1) * value._3 / 100 + acc
    })
  }

}
