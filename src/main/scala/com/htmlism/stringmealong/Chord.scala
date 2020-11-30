package com.htmlism.stringmealong

import com.htmlism.stringmealong.Interval._

trait Chord {

  /**
    * List of intervals from the root of the chord
    */
  def intervals: List[Interval]
}

case class Triad(firstInterval: Interval, secondInterval: Interval) extends Chord {
  def intervals: List[Interval] =
    List(firstInterval, secondInterval)

  def and(thirdInterval: Interval): Seventh =
    Seventh(firstInterval, secondInterval, thirdInterval)
}

object Triad {
  val Major: Triad =
    Triad(MajorThird, PerfectFifth)

  val Minor: Triad =
    Triad(MinorThird, PerfectFifth)

  val Diminished: Triad =
    Triad(MinorThird, DiminishedFifth)

  val Augmented: Triad =
    Triad(MajorThird, AugmentedFifth)

  def atScaleDegree(deg: ScaleDegree, triad: Triad): String = {
    val baseRoman =
      ScaleDegree
        .asRoman(deg)

    triad match {
      case Major =>
        baseRoman

      case Minor =>
        baseRoman.toLowerCase

      case Diminished =>
        baseRoman + "o" // dim

      case Augmented =>
        baseRoman + "+" // aug

      case _ =>
        deg.toString + " " + triad.toString
    }
  }
}

case class Seventh(firstInterval: Interval, secondInterval: Interval, thirdInterval: Interval) extends Chord {
  def intervals: List[Interval] =
    List(firstInterval, secondInterval, thirdInterval)
}

object Seventh {
  val Major: Seventh =
    Triad.Major.and(MajorSeventh)

  val Dominant: Seventh =
    Triad.Major.and(MinorSeventh)

  val Minor: Seventh =
    Triad.Minor.and(MinorSeventh)

  val HalfDiminshed: Seventh =
    Triad.Diminished.and(MinorSeventh)

  val Diminished: Seventh =
    Triad.Diminished.and(DiminishedSeventh)

  def atScaleDegree(deg: ScaleDegree, seventh: Seventh): String = {
    val baseRoman =
      ScaleDegree
        .asRoman(deg)

    seventh match {
      case Dominant =>
        baseRoman + "7"

      case Major =>
        baseRoman + "M7"

      case Minor =>
        baseRoman.toLowerCase + "7"

      case Diminished =>
        baseRoman.toLowerCase + "o7"

      case HalfDiminshed =>
        baseRoman.toLowerCase + "7b5"

      case _ =>
        baseRoman + " " + seventh.toString
    }
  }
}
