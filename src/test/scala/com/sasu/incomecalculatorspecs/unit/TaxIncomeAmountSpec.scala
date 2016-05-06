package com.sasu.incomecalculatorspecs.unit

import com.sasu.incomecalculator.{DefaultTaxIncomeAmount, DefaultTaxSocietyAmount}
import org.scalatest.{FlatSpec, Matchers}

class TaxIncomeAmountSpec extends FlatSpec with Matchers {

  "Tax income amount" should "equals 0 if income amount is equals to 3" in {
    new DefaultTaxIncomeAmount().calculate(3) should be(0)
  }

  "Tax income amount" should "equals 0 if income amount is equals to 9700" in {
    new DefaultTaxIncomeAmount().calculate(9700) should be(0)
  }

  "Tax income amount" should "reaches 30% if income amount is equals to 20000" in {
    new DefaultTaxIncomeAmount().calculate(30000) should be((17091 * 14 / 100 + (30000f - 26791) * 30 / 100).round)
  }

  "Tax income amount" should "reaches 30% if income amount is equals to 38122" in {
    new DefaultTaxIncomeAmount().calculate(31000) should be((17091 * 14 / 100 + (31000f - 26791) * 30 / 100).round)
  }


}
