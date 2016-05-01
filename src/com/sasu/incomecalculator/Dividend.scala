package com.sasu.incomecalculator

class Dividend(freelanceCriteria: FreelanceCriteria) {

  val originalValue = freelanceCriteria.freelanceCost * freelanceCriteria.nbWorkDaysInAYear - freelanceCriteria.charges - freelanceCriteria.salaryCost

  private val afterIs = {
    val is = if (originalValue <= 38120)
      originalValue * 15 / 100
    else
      originalValue * 33.33 / 100
    originalValue - is
  }

  val afterCSG = afterIs - afterIs * 15.5 / 100

  val incomeTax = afterCSG * 60 / 100 - afterIs * 5.1 / 100

}

