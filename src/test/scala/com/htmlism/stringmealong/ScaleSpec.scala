package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ScaleSpec extends AnyFunSuite with Matchers:
  test("natural minor derivation from parallel major"):
    Scale
      .MajorScale
      .flat(ScaleDegree(3))
      .flat(ScaleDegree(6))
      .flat(ScaleDegree(7)) shouldBe Scale.NaturalMinorScale

  test("harmonic minor derivation from parallel major"):
    Scale
      .MajorScale
      .flat(ScaleDegree(3))
      .flat(ScaleDegree(6)) shouldBe Scale.HarmonicMinorScale

  test("diatonic cycle"):
    CheckpointBuilder
      .empty
      .assert:
        Scale.Diatonic.Ionian.nextIntervalSequence shouldBe Scale.Diatonic.Dorian
      .assert:
        Scale.Diatonic.Dorian.nextIntervalSequence shouldBe Scale.Diatonic.Phrygian
      .assert:
        Scale.Diatonic.Phrygian.nextIntervalSequence shouldBe Scale.Diatonic.Lydian
      .assert:
        Scale.Diatonic.Lydian.nextIntervalSequence shouldBe Scale.Diatonic.Myxolydian
      .assert:
        Scale.Diatonic.Myxolydian.nextIntervalSequence shouldBe Scale.Diatonic.Aeolion
      .assert:
        Scale.Diatonic.Aeolion.nextIntervalSequence shouldBe Scale.Diatonic.Locrian
      .assert:
        Scale.Diatonic.Locrian.nextIntervalSequence shouldBe Scale.Diatonic.Ionian
      .reportAll
