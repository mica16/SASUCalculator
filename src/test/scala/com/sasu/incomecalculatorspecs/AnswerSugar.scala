package com.sasu.incomecalculatorspecs

import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

trait AnswerSugar {

  implicit def toAnswer[T](f: () => T): Answer[T] = new Answer[T] {
    override def answer(invocation: InvocationOnMock): T = f()
  }

  implicit def toAnswerWithArguments[T](f: (InvocationOnMock) => T): Answer[T] = new Answer[T] {
    override def answer(invocation: InvocationOnMock): T = f(invocation)
  }

}
