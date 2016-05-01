package com.sasu.incomecalculator

case class Income(freelanceCriterias: FreelanceCriterias, annualIncome: Double) {

  val monthlyIncome = annualIncome / 12
  val monthlySalary = freelanceCriterias.monthlySalary
  val freelanceCost = freelanceCriterias.freelanceCost
  val charges = freelanceCriterias.charges

}
