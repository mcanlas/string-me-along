package com.htmlism

import cats.data.NonEmptyList

/**
  * The interger values for notes come from a modified version of https://en.wikipedia.org/wiki/Pitch_class#Integer_notation
  */
package object stringmealong {
  val C: Note  = Note(0)
  val Cs: Note = Note(1)
  val D: Note  = Note(2)
  val Eb: Note = Note(3)
  val E: Note  = Note(4)
  val F: Note  = Note(5)
  val Fs: Note = Note(6)
  val G: Note  = Note(7)

  val Gs: Note = Note(8)
  val Ab: Note = Note(8)

  val A: Note  = Note(9)
  val Bb: Note = Note(10)
  val B: Note  = Note(11)

  val guitar: StringInstrument  = StringInstrument(10, NonEmptyList.of(E.o4, B.o3, G.o3, D.o3, A.o2, E.o2))
  val ukulele: StringInstrument = StringInstrument(10, NonEmptyList.of(A.o4, E.o4, C.o4, G.o4))
}
