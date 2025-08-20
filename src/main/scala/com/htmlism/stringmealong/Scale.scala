package com.htmlism.stringmealong

import scala.annotation.tailrec

import cats.data.NonEmptyList

import com.htmlism.stringmealong.Interval.*
import com.htmlism.stringmealong.syntax.*

case class Scale(intervals: NonEmptyList[Interval]):

  /**
    * Returns a new scale with the Nth scale degree flattened
    */
  def flat(deg: ScaleDegree): Scale =
    // accounts for zero indexing AND the difference between intervals and degrees
    val intervalStartIndex = deg.n - 2
    val intervalEndIndex   = deg.n - 1

    Scale:
      intervals
        .zipWithIndex
        // TODO where is the updated method on NonEmptyList?
        .map: (int, ix) =>
          if ix == intervalStartIndex then new Interval(intervals.toList(intervalStartIndex).semitones - 1)
          else if ix == intervalEndIndex then Interval(intervals.toList(intervalEndIndex).semitones + 1)
          else int

  /**
    * Returns a new scale with the Nth scale degree flattened
    */
//  def sharp(n: Int): Scale =
//    ???

  def nextIntervalSequence: Scale =
    Scale(
      NonEmptyList
        .fromListUnsafe(
          intervals
            .tail
            .appended(intervals.head)
        )
    )

  def intervalAtIndex(n: Int): Interval =
    intervals.toList(n % intervals.length)

object Scale:
  def toPitchCollectionFrom(root: Pitch, scale: Scale): List[Pitch] =
    pitchList(NonEmptyList.of(root), scale.intervals.toList)

  @tailrec
  private def pitchList(xs: NonEmptyList[Pitch], intervals: List[Interval]): List[Pitch] =
    intervals match
      case newestInterval :: remainingIntervals =>
        val newPitch =
          List
            .fill(newestInterval.semitones)(())
            .foldLeft(xs.head)((acc, _) => acc.sharp)

        pitchList(xs.prepend(newPitch), remainingIntervals)

      case Nil =>
        xs
          .toList
          .reverse

  val MajorScale: Scale =
    Scale(NonEmptyList.of(WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, WholeStep, HalfStep))

  val NaturalMinorScale: Scale =
    Scale(NonEmptyList.of(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep))

  val HarmonicMinorScale: Scale =
    Scale(NonEmptyList.of(WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, AugmentedSecond, HalfStep))

  val MajorPentatonicScale: Scale =
    Scale(NonEmptyList.of(WholeStep, WholeStep, AugmentedSecond, WholeStep, AugmentedSecond))

  val MinorPentatonicScale: Scale =
    Scale(NonEmptyList.of(AugmentedSecond, AugmentedSecond, WholeStep, AugmentedSecond, WholeStep))

  object Diatonic:
    val Ionian: Scale =
      MajorScale

    val Dorian: Scale =
      Scale(NonEmptyList.of(WholeStep, HalfStep, WholeStep, WholeStep, WholeStep, HalfStep, WholeStep))

    val Phrygian: Scale =
      Scale(NonEmptyList.of(HalfStep, WholeStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep))

    val Lydian: Scale =
      Scale(NonEmptyList.of(WholeStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, HalfStep))

    val Myxolydian: Scale =
      Scale(NonEmptyList.of(WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, HalfStep, WholeStep))

    val Aeolion: Scale =
      NaturalMinorScale

    val Locrian: Scale =
      Scale(NonEmptyList.of(HalfStep, WholeStep, WholeStep, HalfStep, WholeStep, WholeStep, WholeStep))

    val all: NonEmptyList[Scale] =
      NonEmptyList.of(Ionian, Dorian, Phrygian, Lydian, Myxolydian, Aeolion, Locrian)

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
