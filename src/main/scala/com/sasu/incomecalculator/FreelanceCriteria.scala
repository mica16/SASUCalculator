package com.sasu.incomecalculator

class FreelanceCriteria(val turnover: Float, val fees: Float, val monthlySalary: Float) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[FreelanceCriteria]

  override def equals(other: Any): Boolean = other match {
    case that: FreelanceCriteria =>
      (that canEqual this) &&
        turnover == that.turnover &&
        fees == that.fees &&
        monthlySalary == that.monthlySalary
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(turnover, fees, monthlySalary)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object FreelanceCriteria {

  def apply(turnover: Float, fees: Float, monthlySalary: Float): FreelanceCriteria = {
    new FreelanceCriteria(turnover, fees, monthlySalary)
  }

  def apply(priceByDay: Float, nbYearlyWorkedDays: Float, fees: Float, monthlySalary: Float): FreelanceCriteria = {
    new FreelanceCriteria(priceByDay * nbYearlyWorkedDays, fees, monthlySalary)
  }

}
