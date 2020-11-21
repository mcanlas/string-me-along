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

  def nextIntervalSequence: Scale =
    Scale(intervals.tail ::: List(intervals.head))
}

object Scale {
  val MajorScale: Scale =
    Scale(List(WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, WholeStep, HalfStep))

  val NaturalMinorScale: Scale =
    Scale(List(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep))

  val HarmonicMinorScale: Scale =
    Scale(List(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, AugmentedSecond, HalfStep))

  val MajorPentatonicScale: Scale =
    Scale(List(WholeStep, WholeStep, AugmentedSecond, WholeStep, AugmentedSecond))

  val MinorPentatonicScale: Scale =
    Scale(List(AugmentedSecond, AugmentedSecond, WholeStep, AugmentedSecond, WholeStep))

  object Diatonic {
    val Ionian: Scale =
      MajorScale

    val Dorian: Scale =
      Scale(List(WholeStep, HalfStep, WholeStep, WholeStep, WholeStep, HalfStep, WholeStep))

    val Phrygian: Scale =
      Scale(List(HalfStep, WholeStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep))

    val Lydian: Scale =
      Scale(List(WholeStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, HalfStep))

    val Myxolydian: Scale =
      Scale(List(WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, WholeStep))

    val Aeolion: Scale =
      NaturalMinorScale

    val Locrian: Scale =
      Scale(List(HalfStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, WholeStep))
  }
}