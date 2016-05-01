package com.sasu.incomecalculator

case class Income(freelanceCriterias: FreelanceCriterias, annualIncome: Double) {

  val monthlyIncome = annualIncome / 12

}
