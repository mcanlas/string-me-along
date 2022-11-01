package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax._

class NoteSpec extends AnyFunSuite with Matchers:
  test("the next pitch after C is C#") {
    C.sharp shouldBe Cs
  }

  test("the next pitch after B is C (octave test)") {
    B.sharp shouldBe C
  }

  test("the previous pitch from C# is C") {
    Cs.flat shouldBe C
  }

  test("the previous pitch from C is B (octave test)") {
    C.flat shouldBe B
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

  test("C raised by a minor third is Eb") {
    C.raisedBy(Interval.MinorThird) shouldBe Eb
  }

  test("C raised by a major third is E") {
    C.raisedBy(Interval.MajorThird) shouldBe E
  }
