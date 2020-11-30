package com.htmlism.stringmealong

case class OctatonicSpelling(n: Int) {
  def spell: String =
    OctatonicSpelling.spellings(n)

  def nextOctatonic: OctatonicSpelling =
    if (n < 6)
      this.copy(n = n + 1)
    else
      this.copy(n = 0)
}

object OctatonicSpelling {
  val A: OctatonicSpelling = OctatonicSpelling(0)
  val B: OctatonicSpelling = OctatonicSpelling(1)
  val C: OctatonicSpelling = OctatonicSpelling(2)
  val D: OctatonicSpelling = OctatonicSpelling(3)
  val E: OctatonicSpelling = OctatonicSpelling(4)
  val F: OctatonicSpelling = OctatonicSpelling(5)
  val G: OctatonicSpelling = OctatonicSpelling(6)

  val spellings = List("A", "B", "C", "D", "E", "F", "G")

  val notes =
    Map(
      C -> Note(1),
      D -> Note(3),
      E -> Note(5),
      F -> Note(6),
      G -> Note(8),
      A -> Note(10),
      B -> Note(12)
    )
}
