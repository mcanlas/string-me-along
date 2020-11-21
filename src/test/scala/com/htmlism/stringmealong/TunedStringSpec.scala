package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TunedStringSpec extends AnyFunSuite with Matchers {
  test("a tuned string comes from a pitch and fret length") {
    C.o4 * 2 shouldBe TunedString(List(C.o4, C.o4.sharp, C.o4.sharp.sharp))
  }

  test("C4 string with four frets can play C and E") {
    (C.o4 * 4).fingerings(C) should contain theSameElementsInOrderAs List(0)
    (C.o4 * 4).fingerings(E) should contain theSameElementsInOrderAs List(4)
  }
}
