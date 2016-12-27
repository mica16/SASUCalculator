package com.sasu.incomecalculatorspecs.unit

import com.sasu.incomecalculator.DefaultTaxSocietyAmount
import org.scalatest.{Matchers, FlatSpec}

class TaxSocietyAmountSpec extends FlatSpec with Matchers {

  "Tax society amount" should "equal 15% if dividends initial amount is equals to 37120" in {
    new DefaultTaxSocietyAmount().calculate(37120) should be(37120 * 15 / 100)
  }

  "Tax society amount" should "equal 15% if dividends initial amount is equals to 38120" in {
    new DefaultTaxSocietyAmount().calculate(38120) should be(38120 * 15 / 100)
  }

  "Tax society amount" should "reach 33.33% if dividends initial amount is equals to 38121" in {
    new DefaultTaxSocietyAmount().calculate(38121) should be((38120 * 15 / 100 + 1 * 33.33f / 100).round)
  }

  "Tax society amount" should "reach 33.33% if dividends initial amount is equals to 38122" in {
    new DefaultTaxSocietyAmount().calculate(38122) should be((38120 * 15 / 100 + 2 * 33.33f / 100).round)
  }


}
