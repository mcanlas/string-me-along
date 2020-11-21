package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ScaleSpec extends AnyFunSuite with Matchers {
  test("natural minor derivation from parallel major") {
    Scale
      .MajorScale
      .flat(3)
      .flat(6)
      .flat(7) shouldBe Scale.NaturalMinorScale
  }

  test("harmonic minor derivation from parallel major") {
    Scale
      .MajorScale
      .flat(3)
      .flat(6) shouldBe Scale.HarmonicMinorScale
  }
}
