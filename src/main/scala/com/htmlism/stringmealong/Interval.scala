package com.htmlism.stringmealong

abstract class Interval(val semitones: Int)

object Interval {
  case object Unison extends Interval(0)

  case object MinorSecond extends Interval(1)

  case object MajorSecond extends Interval(2)

  case object MinorThird extends Interval(3)

  case object MajorThird extends Interval(4)

  case object PerfectFourth extends Interval(5)

  case object Tritone extends Interval(6)

  case object PerfectFifth extends Interval(7)

  case object MinorSixth extends Interval(8)

  case object MajorSixth extends Interval(9)

  case object MinorSeventh extends Interval(10)

  case object MajorSeventh extends Interval(11)

  case object Octave extends Interval(12)
}


