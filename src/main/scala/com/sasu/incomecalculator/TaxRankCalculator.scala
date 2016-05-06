package com.sasu.incomecalculator

object TaxRankCalculator {

  def calculate(refValue: Float, rankIntervalLists: List[(Float, Float, Float)]): Float = {
    rankIntervalLists.foldLeft(0f)((acc, value) => {
      if (refValue <= value._1)
        return acc
      ((if (refValue >= value._2)
        value._2 - value._1
      else {
        refValue - value._1
      }) * value._3 / 100 + acc).round
    })
  }

}
