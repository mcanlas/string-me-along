package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax.*

class MajorScaleDegreeSpec extends AnyFunSuite with Matchers:
  test("modes as major scale modifications"):
    for s <- Scale.Diatonic.all do
      val majorScaleIntervalsWithRoot =
        Interval.Root :: Scale.MajorScale.intervals

      val diatonicScaleIntervalsWithRoot =
        Interval.Root :: s.intervals

      val modifiedMajorScale =
        for (n <- 1 to 8) yield
          val majorSemitones =
            majorScaleIntervalsWithRoot
              .take(n)
              .foldLeft(Note(0))((n, i) => n.raisedBy(i))

          val diatonicSemitones =
            diatonicScaleIntervalsWithRoot
              .take(n)
              .foldLeft(Note(0))((n, i) => n.raisedBy(i))

          val semitonesDelta =
            diatonicSemitones.n - majorSemitones.n

          MajorScaleDegree(n, semitonesDelta)

      println:
        Scale.Diatonic.label(s) + "\n  " + modifiedMajorScale.map(_.spell).mkString(", ")
