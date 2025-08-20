package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DiatonicChordsSpec extends AnyFunSuite with Matchers:
  test("diatonic triads"):
    for s <- Scale.Diatonic.all.toList do
      println()
      println(Scale.Diatonic.label(s))

      for scaleDegreeN <- 1 to 7 do
        val baseIntervalIndex = scaleDegreeN - 1
//        println(baseIntervalIndex)

        val firstInterval =
          s.intervalAtIndex(baseIntervalIndex + 0) +
            s.intervalAtIndex(baseIntervalIndex + 1)

        val secondInterval =
          s.intervalAtIndex(baseIntervalIndex + 0) +
            s.intervalAtIndex(baseIntervalIndex + 1) +
            s.intervalAtIndex(baseIntervalIndex + 2) +
            s.intervalAtIndex(baseIntervalIndex + 3)

        val triad =
          Triad(firstInterval, secondInterval)

        println(Triad.atScaleDegree(ScaleDegree(scaleDegreeN), triad))

  test("diatonic sevenths"):
    for s <- Scale.Diatonic.all.toList do
      println()
      println(Scale.Diatonic.label(s))

      for scaleDegreeN <- 1 to 7 do
        val baseIntervalIndex = scaleDegreeN - 1
        //        println(baseIntervalIndex)

        val firstInterval =
          s.intervalAtIndex(baseIntervalIndex + 0) +
            s.intervalAtIndex(baseIntervalIndex + 1)

        val secondInterval =
          s.intervalAtIndex(baseIntervalIndex + 0) +
            s.intervalAtIndex(baseIntervalIndex + 1) +
            s.intervalAtIndex(baseIntervalIndex + 2) +
            s.intervalAtIndex(baseIntervalIndex + 3)

        val thirdInterval =
          s.intervalAtIndex(baseIntervalIndex + 0) +
            s.intervalAtIndex(baseIntervalIndex + 1) +
            s.intervalAtIndex(baseIntervalIndex + 2) +
            s.intervalAtIndex(baseIntervalIndex + 3) +
            s.intervalAtIndex(baseIntervalIndex + 4) +
            s.intervalAtIndex(baseIntervalIndex + 5)

        val seventh =
          Seventh(firstInterval, secondInterval, thirdInterval)

        println(Seventh.atScaleDegree(ScaleDegree(scaleDegreeN), seventh))
