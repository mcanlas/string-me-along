package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax.*

class IntervalStackingSpec extends AnyFunSuite with Matchers:
  test("major chord: major minor stacking"):
    C.raisedBy(Interval.MajorThird) shouldBe E

    C
      .raisedBy(Interval.MajorThird)
      .raisedBy(Interval.MinorThird) shouldBe G

  test("minor chord: minor major stacking"):
    C.raisedBy(Interval.MinorThird) shouldBe Eb

    C
      .raisedBy(Interval.MinorThird)
      .raisedBy(Interval.MajorThird) shouldBe G
