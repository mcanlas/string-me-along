package com.htmlism

import cats.data.NonEmptyList

package object stringmealong {
  val C: Note  = Note(1)
  val Cs: Note = Note(2)
  val D: Note  = Note(3)
  val Eb: Note = Note(4)
  val E: Note  = Note(5)
  val F: Note  = Note(6)
  val Fs: Note = Note(7)
  val G: Note  = Note(8)

  val Gs: Note = Note(9)
  val Ab: Note = Note(9)

  val A: Note  = Note(10)
  val Bb: Note = Note(11)
  val B: Note  = Note(12)

  val guitar: StringInstrument  = StringInstrument(10, NonEmptyList.of(E.o4, B.o3, G.o3, D.o3, A.o2, E.o2))
  val ukulele: StringInstrument = StringInstrument(10, NonEmptyList.of(A.o4, E.o4, C.o4, G.o4))
}
