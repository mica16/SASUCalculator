package com.sasu.incomecalculator

class Salary(monthlySalary: Double) {

  val annualSalary = monthlySalary * 12
  val salaryCost = annualSalary + annualSalary * 89 / 100
  val incomeTax = annualSalary * 90 / 100

}
