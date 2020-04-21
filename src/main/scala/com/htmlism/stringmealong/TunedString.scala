package com.htmlism.stringmealong

object TunedString {
  def apply(pitch: Pitch, n: Int): TunedString =
    TunedString {
      pitchList(List(pitch), n)
    }

  /**
   * Generates an ascending list of pitches raised by `n` semitones.
   */
  @scala.annotation.tailrec
  def pitchList(xs: List[Pitch], n: Int): List[Pitch] =
    if (n < 1)
      xs.reverse
    else
      pitchList(xs.head.s :: xs, n - 1)
}

case class TunedString(pitches: List[Pitch]) {
  def fingering(n: Note): List[Int] =
    pitches
      .zipWithIndex
      .filter { case (pitch, _) => pitch.note == n }
      .map(_._2)
}
