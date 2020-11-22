package com.htmlism.stringmealong

case class Interval(semitones: Int) {
  def + (that: Interval): Interval =
    Interval(this.semitones + that.semitones)
}

object Interval {
  lazy val WholeStep: Interval =
    MajorSecond

  lazy val HalfStep: Interval =
    MinorSecond

  lazy val AugmentedSecond: Interval =
    MinorThird

  lazy val Root: Interval =
    Unison

  lazy val AugmentedFifth: Interval =
    MinorSixth

  lazy val DiminishedFifth: Interval =
    Tritone

  lazy val DiminishedSeventh: Interval =
    MajorSixth

  val Unison: Interval = Interval(0)

  val MinorSecond: Interval = Interval(1)

  val MajorSecond: Interval = Interval(2)

  val MinorThird: Interval = Interval(3)

  val MajorThird: Interval = Interval(4)

  val PerfectFourth: Interval = Interval(5)

  val Tritone: Interval = Interval(6)

  val PerfectFifth: Interval = Interval(7)

  val MinorSixth: Interval = Interval(8)

  val MajorSixth: Interval = Interval(9)

  val MinorSeventh: Interval = Interval(10)

  val MajorSeventh: Interval = Interval(11)

  val Octave: Interval = Interval(12)
}


