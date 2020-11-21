package com.htmlism.stringmealong

object Pitch {
  @scala.annotation.tailrec
  def semitones(pitch: Pitch, n: Int): Pitch =
    if (n < 1)
      pitch
    else
      semitones(pitch.sharp, n - 1)
}

case class Pitch(note: Note, octave: Octave) {
  def sharp: Pitch =
    if (note.n < 12)
      this.copy(note = note.sharp)
    else
      Pitch(Note(1), Octave(this.octave.n + 1))

  def flat: Pitch =
    if (note.n == 1)
      Pitch(Note(12), Octave(this.octave.n - 1))
    else
      this.copy(note = note.flat)

  def third: Pitch =
    Pitch.semitones(this, 4)

  def fifth: Pitch =
    Pitch.semitones(this, 7)

  def *(n: Int): TunedString =
    TunedString(this, n)
}
