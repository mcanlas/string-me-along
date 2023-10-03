package com.htmlism.stringmealong

import com.htmlism.stringmealong.syntax.*

object Pitch:
  given MusicallyOrdinal[Pitch] with
    def sharpen(p: Pitch): Pitch =
      if p.note.n < Note.max then p.copy(note = p.note.sharp)
      else Pitch(note                         = Note(Note.min), octave = Octave(p.octave.n + 1))

    def flatten(p: Pitch): Pitch =
      if p.note.n == Note.min then Pitch(note = Note(Note.max), octave = Octave(p.octave.n - 1))
      else p.copy(note                        = p.note.flat)

case class Pitch(note: Note, octave: Octave):
  def *(n: Int): TunedString =
    TunedString(this, n)
