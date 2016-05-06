package com.sasu.incomecalculatorspecs.unit

import com.sasu.incomecalculator._
import com.sasu.incomecalculatorspecs.AnswerSugar
import org.mockito.invocation.InvocationOnMock
import org.scalatest._
import org.scalatest.mock._
import org.mockito.Mockito._
import org.mockito.Matchers._

class SASUIncomeCalculatorSpec extends FlatSpec with Matchers with MockitoSugar with AnswerSugar {

  "Income" should "equals 36755e/year for 80000 8000, 2500" in {
    val taxSocietyAmountMock = mock[TaxSocietyAmount]
    when(taxSocietyAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => invocation.getArgument(0).asInstanceOf[Float] * 15 / 100)
    val taxIncomeAmountMock = mock[TaxIncomeAmount]
    when(taxIncomeAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => {
      17091 * 14 / 100 + (invocation.getArgument(0).asInstanceOf[Float] - 26791) * 30 / 100
    })
    val calculator = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(taxSocietyAmountMock), new DefaultIncomeTaxRules(taxIncomeAmountMock))
    val income = calculator.calculate(List(FreelanceCriteria(turnover = 80000, fees = 8000, monthlySalary = 2500)))
    income should be(Income(80000, 8000, 2500, 36755))
  }

  "Income" should "equals 40142e/year for 82000, 6000, 2300" in {
    val taxSocietyAmountMock = mock[TaxSocietyAmount]
    when(taxSocietyAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => invocation.getArgument(0).asInstanceOf[Float] * 15 / 100)
    val taxIncomeAmountMock = mock[TaxIncomeAmount]
    when(taxIncomeAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => {
      17091 * 14 / 100 + (invocation.getArgument(0).asInstanceOf[Float] - 26791) * 30 / 100
    })
    val calculator = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(taxSocietyAmountMock), new DefaultIncomeTaxRules(taxIncomeAmountMock))
    val income = calculator.calculate(List(FreelanceCriteria(turnover = 82000, fees = 6000, monthlySalary = 2300)))
    income should be(Income(82000, 6000, 2300, 40142))
  }

  it should "be able to process multiple simulations" in {
    val taxSocietyAmountMock = mock[TaxSocietyAmount]
    when(taxSocietyAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => invocation.getArgument(0).asInstanceOf[Float] * 15 / 100)
    val taxIncomeAmountMock = mock[TaxIncomeAmount]
    when(taxIncomeAmountMock.calculate(anyFloat())).thenAnswer((invocation: InvocationOnMock) => {
      17091 * 14 / 100 + (invocation.getArgument(0).asInstanceOf[Float] - 26791) * 30 / 100
    })
    val calculator = new SASUIncomeCalculator(new DefaultDueAmountRulesBeforeIncomeTax(taxSocietyAmountMock), new DefaultIncomeTaxRules(taxIncomeAmountMock))
    val incomes = calculator.calculate(List(FreelanceCriteria(turnover = 80000, fees = 8000, monthlySalary = 2500),
      FreelanceCriteria(turnover = 82000, fees = 6000, monthlySalary = 2300)))
    incomes should be(List(Income(80000, 8000, 2500, 36755), Income(82000, 6000, 2300, 40142)))
  }

}
