package com.sasu.incomecalculatorspecs.unit

import com.sasu.incomecalculator.{IncomesFormatter, Income}
import org.scalatest.{Matchers, FlatSpec}

class IncomesFormatterSpec extends FlatSpec with Matchers {

  "Formatter" should "format results of Income into a specific set of strings" in {
    val incomes = List(Income(82000, 6000, 2300, 40142), Income(80000, 8000, 2500, 36755))
    new IncomesFormatter().format(incomes) should be("82000 euros de chiffre d'affaires, 6000 euros de frais, 2300 euros de salaire net/mois : 40142 euros/an," +
      s" soit ${40142/12} euros/mois\n" +
      s"80000 euros de chiffre d'affaires, 8000 euros de frais, 2500 euros de salaire net/mois : 36755 euros/an, soit ${36755/12} euros/mois")
    val incomes2 = List(Income(70000, 6000, 2300, 35000), Income(60000, 8000, 2500, 25000))
    new IncomesFormatter().format(incomes2) should be("70000 euros de chiffre d'affaires, 6000 euros de frais, 2300 euros de salaire net/mois : 35000 euros/an," +
      s" soit ${35000/12} euros/mois\n" +
      s"60000 euros de chiffre d'affaires, 8000 euros de frais, 2500 euros de salaire net/mois : 25000 euros/an, soit ${25000/12} euros/mois")
  }

  "Formatter" should "order display by income amount, the highest on top" in {
    val incomes = List(Income(80000, 8000, 2500, 36755), Income(82000, 6000, 2300, 40142))
    new IncomesFormatter().format(incomes) should be("82000 euros de chiffre d'affaires, 6000 euros de frais, 2300 euros de salaire net/mois : 40142 euros/an," +
      s" soit ${40142/12} euros/mois\n" +
      s"80000 euros de chiffre d'affaires, 8000 euros de frais, 2500 euros de salaire net/mois : 36755 euros/an, soit ${36755/12} euros/mois")
  }

}
