package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class NoteSpec extends AnyFunSuite with Matchers {
  test("the next pitch after C is C#") {
    C.s shouldBe Cs
  }

  test("the next pitch after B is C (octave test)") {
    B.s shouldBe C
  }

  test("the previous pitch from C# is C") {
    Cs.b shouldBe C
  }

  test("the previous pitch from C is B (octave test)") {
    C.b shouldBe B
  }

  test("a third from C is E") {
    C.third shouldBe E
  }

  test("a fifth from C is G") {
    C.fifth shouldBe G
  }

  test("a third from A is C#") {
    A.third shouldBe Cs
  }
}
