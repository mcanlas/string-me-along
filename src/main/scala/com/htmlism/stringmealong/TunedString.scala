package com.htmlism.stringmealong

import cats.data.NonEmptyList

import com.htmlism.stringmealong.syntax.*

object TunedString:
  def apply(pitch: Pitch, n: Int): TunedString =
    TunedString:
      pitchList(NonEmptyList.of(pitch), n)

  /**
    * Generates an ascending list of pitches raised by `n` semitones.
    */
  @scala.annotation.tailrec
  def pitchList(xs: NonEmptyList[Pitch], n: Int): List[Pitch] =
    if n < 1 then xs.toList.reverse
    else pitchList(xs.head.sharp :: xs, n - 1)

/**
  * A collection of pitches starting from an open tone to each fretted tone
  */
case class TunedString(pitches: List[Pitch]):
  def fingerings(n: Note): List[Int] =
    pitches
      .zipWithIndex
      .filter { case (pitch, _) => pitch.note == n }
      .map(_._2)
