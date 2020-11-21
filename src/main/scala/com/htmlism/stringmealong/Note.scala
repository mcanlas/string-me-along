package com.htmlism.stringmealong

object Note {
  val min: Int = 0
  val max: Int = 11

  @scala.annotation.tailrec
  def raiseBySemitones(note: Note, n: Int): Note =
    if (n < 1)
      note
    else
      raiseBySemitones(note.sharp, n - 1)

  def spelling(n: Int): String =
    List("C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B")(n)
}

case class Note(n: Int) {
  def o2: Pitch = Pitch(this, Octave(2))

  def o3: Pitch = Pitch(this, Octave(3))

  def o4: Pitch = Pitch(this, Octave(4))

  def sharp: Note =
    if (n < Note.max)
      Note(n + 1)
    else
      Note(Note.min)

  def flat: Note =
    if (n == Note.min)
      Note(Note.max)
    else
      Note(n - 1)

  def third: Note =
    Note.raiseBySemitones(this, 4)

  def fifth: Note =
    Note.raiseBySemitones(this, 7)

  def raisedBy(int: Interval): Note =
    Note.raiseBySemitones(this, int.semitones)
}
