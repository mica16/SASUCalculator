package com.sasu.incomecalculator

case class Income(freelanceCriteria: FreelanceCriteria, annualIncome: Double) {

  val monthlyIncome = annualIncome / 12
  val monthlySalary = freelanceCriteria.monthlySalary
  val freelanceCost = freelanceCriteria.freelanceCost
  val charges = freelanceCriteria.charges
  val nbWorkDaysInAYear = freelanceCriteria.nbWorkDaysInAYear

}
