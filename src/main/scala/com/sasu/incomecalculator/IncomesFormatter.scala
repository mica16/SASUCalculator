package com.sasu.incomecalculator

class IncomesFormatter {

  def format(incomes: List[Income]): String = {

    def traverse(incomes: List[Income]): String = {
      incomes match {
        case income :: Nil =>
          formatSalary(income)
        case income :: xs =>
          formatSalary(income) + jumpLine + traverse(xs)
        case _ => ""
      }
    }
   traverse(incomes.sortBy(_.amount).reverse)
  }

  private def formatSalary(income: Income) = {
    s"${income.turnover.round} euros de chiffre d'affaires, ${income.fees.round} euros de frais, " +
      s"${income.monthlySalary.round} euros de salaire net/mois : ${income.amount.round} euros/an, soit ${income.amount.round / 12} euros/mois"
  }

  private def jumpLine = {
    "\n"
  }

}
