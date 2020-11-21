package com.htmlism.stringmealong

import com.htmlism.stringmealong.Interval._

case class Scale(intervals: List[Interval]) {
  /**
    * Returns a new scale with the Nth scale degree flattened
    */
  def flat(n: Int): Scale = {
    // accounts for zero indexing AND the difference between intervals and degrees
    val intervalStartIndex = n - 2
    val intervalEndIndex = n - 1

    Scale {
      intervals
        .updated(intervalStartIndex, new Interval(intervals(intervalStartIndex).semitones - 1))
        .updated(intervalEndIndex, new Interval(intervals(intervalEndIndex).semitones + 1))
    }
  }

  /**
    * Returns a new scale with the Nth scale degree flattened
    */
  def sharp(n: Int): Scale =
    ???
}

object Scale {
  val MajorScale: Scale =
    Scale(List(WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, WholeStep, HalfStep))

  val NaturalMinorScale: Scale =
    Scale(List(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep))

  val HarmonicMinorScale: Scale =
    Scale(List(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, AugmentedSecond, HalfStep))
}