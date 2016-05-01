package com.sasu.incomecalculator

class IncomeDisplay(incomes: List[Income]) {

  def display() {
    def traverse(incomes: List[Income]) {
      incomes match {
        case income :: Nil =>
          println(formatSalary(income))
        case income :: xs =>
          println(formatSalary(income) + jumpLine)
          traverse(xs)
        case _ =>
      }
    }
   traverse(incomes)
  }

  private def formatSalary(income: Income) = {
    s"${income.freelanceCost} euros/jour : ${income.annualIncome.round}/an =>  ${income.monthlyIncome.round}/mois"
  }

  private def jumpLine = {
    "\n"
  }

}
