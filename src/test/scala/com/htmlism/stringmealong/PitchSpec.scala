package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PitchSpec extends AnyFunSuite with Matchers {
  test("the next pitch after C2 is D2") {
    C.o2.sharp shouldBe Cs.o2
  }

  test("the next pitch after B2 is C3") {
    B.o2.sharp shouldBe C.o3
  }
}
