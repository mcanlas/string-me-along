package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PitchSpec extends AnyFunSuite with Matchers {
  test("the next pitch after C2 is D2") {
    C.o2.s shouldBe Cs.o2
  }

  test("the next pitch after B2 is C3") {
    B.o2.s shouldBe C.o3
  }

  test("a third from C2 is E2") {
    C.o2.third shouldBe E.o2
  }

  test("a fifth from C2 is G2") {
    C.o2.fifth shouldBe G.o2
  }
}
