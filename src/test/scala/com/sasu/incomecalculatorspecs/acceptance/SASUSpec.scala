package com.sasu.incomecalculatorspecs.acceptance

import com.sasu.incomecalculator._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scala.collection.mutable

class SASUSpec extends FeatureSpec with GivenWhenThen with MockitoSugar {


  feature("SASU Income Calculator") {
    scenario("Calculate SASU Income") {
      val sasuIncomeCalculator = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(new DefaultTaxSocietyAmount), new DefaultIncomeTaxRules(new DefaultTaxIncomeAmount))
      val list = mutable.ArrayBuffer[(Float, Float, Float)]()

      Given("a turnover at 80000, fees at 8000 and expected salary at 2500 ")
      list += ((80000, 8000, 2500))

      And("a turnover at 80000, fees at 8000 and expected salary at 2500")
      list += ((82000, 6000, 2300))

      When("balance sheet is made for both")
      val incomes = sasuIncomeCalculator.calculateM(list.toList)

      Then("the results should correspond to the right values")
      assert(incomes == List(Income(80000, 8000, 2500, 36755), Income(82000, 6000, 2300, 40142)))
    }
  }

}