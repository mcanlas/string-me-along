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

  test("diatonic cycle") {
    Scale.Diatonic.Ionian.nextIntervalSequence shouldBe Scale.Diatonic.Dorian
    Scale.Diatonic.Dorian.nextIntervalSequence shouldBe Scale.Diatonic.Phrygian
    Scale.Diatonic.Phrygian.nextIntervalSequence shouldBe Scale.Diatonic.Lydian
    Scale.Diatonic.Lydian.nextIntervalSequence shouldBe Scale.Diatonic.Myxolydian
    Scale.Diatonic.Myxolydian.nextIntervalSequence shouldBe Scale.Diatonic.Aeolion
    Scale.Diatonic.Aeolion.nextIntervalSequence shouldBe Scale.Diatonic.Locrian
    Scale.Diatonic.Locrian.nextIntervalSequence shouldBe Scale.Diatonic.Ionian
  }
}
