package com.sasu.incomecalculator

case class FreelanceCriteria(freelanceCost: Double, nbWorkDaysInAYear: Int, charges: Double, salary: Salary) {

  val monthlySalary = salary.monthlySalary
  val annualSalary = salary.annualSalary
  val salaryCost = salary.salaryCost

}
