package com.htmlism.stringmealong

object Note:
  val min: Int = 0
  val max: Int = 11

  given MusicallyOrdinal[Note] with
    def sharpen(x: Note): Note =
      if x.n < Note.max then Note(x.n + 1)
      else Note(Note.min)

    def flatten(x: Note): Note =
      if x.n == Note.min then Note(Note.max)
      else Note(x.n - 1)

  def spelling(n: Int): String =
    List("C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B")(n)

case class Note(n: Int):
  def o2: Pitch = Pitch(this, Octave(2))

  def o3: Pitch = Pitch(this, Octave(3))

  def o4: Pitch = Pitch(this, Octave(4))
