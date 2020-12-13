package com.htmlism.stringmealong

import scala.annotation.tailrec

import com.htmlism.stringmealong.Interval._
import com.htmlism.stringmealong.syntax._

case class Scale(intervals: List[Interval]) {

  /**
    * Returns a new scale with the Nth scale degree flattened
    */
  def flat(deg: ScaleDegree): Scale = {
    // accounts for zero indexing AND the difference between intervals and degrees
    val intervalStartIndex = deg.n - 2
    val intervalEndIndex   = deg.n - 1

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

  def intervalAtIndex(n: Int): Interval =
    intervals(n % intervals.length)
}

object Scale {
  def toPitchCollectionFrom(root: Pitch, scale: Scale): List[Pitch] =
    pitchList(List(root), scale.intervals)

  @tailrec
  private def pitchList(xs: List[Pitch], intervals: List[Interval]): List[Pitch] =
    intervals match {
      case newestInterval :: remainingIntervals =>
        val newPitch =
          List
            .fill(newestInterval.semitones)(())
            .foldLeft(xs.head)((acc, _) => acc.sharp)

        pitchList(newPitch +: xs, remainingIntervals)

      case Nil =>
        xs.reverse
    }

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

    val all: List[Scale] =
      List(Ionian, Dorian, Phrygian, Lydian, Myxolydian, Aeolion, Locrian)

    private val labels =
      Map(
        Ionian     -> "Ionian",
        Dorian     -> "Dorian",
        Phrygian   -> "Phrygian",
        Lydian     -> "Lydian",
        Myxolydian -> "Myxolydian",
        Aeolion    -> "Aeolion",
        Locrian    -> "Locrian"
      )

    def label(s: Scale): String =
      labels
        .getOrElse(s, "UNRECOGNIZED DIATONIC SCALE")
  }
}
