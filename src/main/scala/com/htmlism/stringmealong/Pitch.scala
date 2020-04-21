package com.htmlism.stringmealong

case class Pitch(note: Note, octave: Octave) {
  def sharp: Pitch =
    if (note.n < 12)
      this.copy(note = Note(note.n + 1))
    else
      Pitch(Note(1), Octave(this.octave.n + 1))
}
