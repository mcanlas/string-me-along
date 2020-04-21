package com.htmlism.stringmealong

object Note {
  @scala.annotation.tailrec
  def semitones(note: Note, n: Int): Note =
    if (n < 1)
      note
    else
      semitones(note.s, n - 1)
}

case class Note(n: Int) {
  def o2: Pitch = Pitch(this, Octave(2))

  def o3: Pitch = Pitch(this, Octave(3))

  def o4: Pitch = Pitch(this, Octave(4))

  def s: Note =
    if (n < 12)
      Note(n + 1)
    else
      Note(1)

  def b: Note =
    if (n == 1)
      Note(12)
    else
      Note(n - 1)

  def third: Note =
    Note.semitones(this, 4)

  def fifth: Note =
    Note.semitones(this, 7)
}
