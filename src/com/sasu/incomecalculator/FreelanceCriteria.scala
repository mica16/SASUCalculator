package com.sasu.incomecalculator

class FreelanceCriteria(val freelanceCost: Double, val nbWorkDaysInAYear: Int, val charges: Double, salary: Salary) {

  val monthlySalary = salary.monthlySalary
  val annualSalary = salary.annualSalary
  val salaryCost = salary.salaryCost
  val incomeTax = salary.incomeTax

}
