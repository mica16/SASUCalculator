package com.sasu.incomecalculatorspecs.unit

import org.mockito.Mockito._
import org.scalatest.FunSpec


class A {

  def test(m: Map[String, String]){}

}

class Test extends FunSpec {


  describe("Should verify exactitude of map contents") {
    it("a Test that doesn't fail....as expected") {
      val a = mock(classOf[A])
      a.test(Map[String, String]("Mikf" -> "yo"))
      verify(a).test(Map[String, String]("Mik" -> "ya")) //should fail !
    }
  }

}
