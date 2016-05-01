package com.sasu.incomecalculator

object TaxRankCalculator {

  def calculate(refValue: Double, rankIntervalLists: List[(Double, Double, Double)]): Double = {
    rankIntervalLists.foldLeft(0d)((acc, value) => {
      if(refValue <= value._1)
        return acc
      (if (refValue >= value._2)
        value._2 - value._1
      else {
        refValue - value._1
      }) * value._3 / 100 + acc
    })
  }

}
