package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax._

class AccidentalsSpec extends AnyFunSuite with Matchers:
  test("sharps") {
    List.iterate(F, 7)(_.raisedBy(Interval.PerfectFifth)) shouldBe List(F, C, G, D, A, E, B)
  }

  test("flats") {
    List.iterate(B, 7)(_.raisedBy(Interval.PerfectFourth)) shouldBe List(B, E, A, D, G, C, F)
  }
