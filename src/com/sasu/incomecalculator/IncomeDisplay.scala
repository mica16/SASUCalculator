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
    s"${income.freelanceCriterias.freelanceCost} euros/jour, ${income.freelanceCriterias.charges.round} euros de frais, " +
      s"${income.freelanceCriterias.monthlySalaryAmount.round} de salaire net par mois : ${income.annualIncome.round}/an =>  ${income.monthlyIncome.round}/mois"
  }

  private def jumpLine = {
    "\n"
  }

}
