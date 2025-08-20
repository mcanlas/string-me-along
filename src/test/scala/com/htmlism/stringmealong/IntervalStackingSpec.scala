package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax.*

class IntervalStackingSpec extends AnyFunSuite with Matchers:
  test("major chord: major minor stacking"):
    CheckpointBuilder
      .empty
      .assert:
        C.raisedBy(Interval.MajorThird) shouldBe E
      .assert:
        C
          .raisedBy(Interval.MajorThird)
          .raisedBy(Interval.MinorThird) shouldBe G
      .reportAll

  test("minor chord: minor major stacking"):
    CheckpointBuilder
      .empty
      .assert:
        C.raisedBy(Interval.MinorThird) shouldBe Eb
      .assert:
        C
          .raisedBy(Interval.MinorThird)
          .raisedBy(Interval.MajorThird) shouldBe G
      .reportAll
