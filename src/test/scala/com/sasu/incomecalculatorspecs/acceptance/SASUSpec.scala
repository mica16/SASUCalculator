package com.sasu.incomecalculatorspecs.acceptance

import com.sasu.incomecalculator._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scala.collection.mutable

class SASUSpec extends FeatureSpec with GivenWhenThen with MockitoSugar {


  feature("SASU Income Calculator") {
    scenario("Calculate SASU Income") {
      val sasuIncomeCalculator = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(new DefaultTaxSocietyAmount), new DefaultIncomeTaxRules(new DefaultTaxIncomeAmount))
      val list = mutable.ArrayBuffer[FreelanceCriteria]()

      Given("a turnover at 80000, fees at 8000 and expected salary at 2500 ")
      list += FreelanceCriteria(turnover = 80000, fees = 8000, monthlySalary = 2500)

      And("a turnover at 80000, fees at 8000 and expected salary at 2500")
      list += FreelanceCriteria(turnover = 82000, fees = 6000, monthlySalary = 2300)

      When("balance sheet is made for both")
      val incomes = sasuIncomeCalculator.calculate(list.toList)

      Then("the results should correspond to the right values")
      assert(incomes == List(Income(80000, 8000, 2500, 36755), Income(82000, 6000, 2300, 40142)))

      And("we should be able to format them")
      assert(new IncomesFormatter().format(incomes) == expectedDisplay(incomes))
    }
  }

  private def expectedDisplay(incomes: List[Income]) = {
    s"82000 euros de chiffre d'affaires, 6000 euros de frais, 2300 euros de salaire net/mois : 40142 euros/an, soit ${40142/12} euros/mois\n" +
    s"80000 euros de chiffre d'affaires, 8000 euros de frais, 2500 euros de salaire net/mois : 36755 euros/an, soit ${36755/12} euros/mois"
  }

}