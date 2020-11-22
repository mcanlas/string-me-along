package com.htmlism.stringmealong

import com.htmlism.stringmealong.Interval._

trait Chord {
  def intervals: List[Interval]
}

case class Triad(firstInterval: Interval, secondInterval: Interval) extends Chord {
  def intervals: List[Interval] =
    List(firstInterval, secondInterval)
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
