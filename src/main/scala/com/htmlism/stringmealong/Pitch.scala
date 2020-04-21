package com.htmlism.stringmealong

object Pitch {
  @scala.annotation.tailrec
  def semitones(pitch: Pitch, n: Int): Pitch =
    if (n < 1)
      pitch
    else
      semitones(pitch.s, n - 1)
}

case class Pitch(note: Note, octave: Octave) {
  def s: Pitch =
    if (note.n < 12)
      this.copy(note = note.s)
    else
      Pitch(Note(1), Octave(this.octave.n + 1))

  def b: Pitch =
    if (note.n == 1)
      Pitch(Note(12), Octave(this.octave.n - 1))
    else
      this.copy(note = note.b)

  def third: Pitch =
    Pitch.semitones(this, 4)

  def fifth: Pitch =
    Pitch.semitones(this, 7)
}
