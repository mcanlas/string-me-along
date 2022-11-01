package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax._

class PitchSpec extends AnyFunSuite with Matchers:
  test("the next pitch after C2 is C#2") {
    C.o2.sharp shouldBe Cs.o2
  }

  test("the next pitch after B2 is C3 (octave test)") {
    B.o2.sharp shouldBe C.o3
  }

  test("the previous pitch from C#2 is C2") {
    C.o2.sharp.flat shouldBe C.o2
  }

  test("the previous pitch from C2 is B1 (octave test)") {
    C.o2.flat shouldBe Pitch(B, Octave(1))
  }

  test("a third from C2 is E2") {
    C.o2.third shouldBe E.o2
  }

  test("a fifth from C2 is G2") {
    C.o2.fifth shouldBe G.o2
  }
