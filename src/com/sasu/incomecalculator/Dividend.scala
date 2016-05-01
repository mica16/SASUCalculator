package com.sasu.incomecalculator

class Dividend(freelanceCriteria: FreelanceCriteria) {

  val originalValue = freelanceCriteria.freelanceCost * freelanceCriteria.nbWorkDaysInAYear - freelanceCriteria.charges - freelanceCriteria.salaryCost

  val afterCSG = afterIs - afterIs * 15.5 / 100

  val incomeTax = afterCSG * 60 / 100 - afterIs * 5.1 / 100

  private def afterIs: Double = {
    originalValue - is
  }

  private val is = {
    val rankIntervalsList = List[(Double,Double,Double)]((0, 38120, 15), (38120, Double.MaxValue, 33.33))
    TaxRankCalculator.calculate(originalValue, rankIntervalsList)
  }

}

