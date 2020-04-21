package com.htmlism.stringmealong

object StringVoicing {
  val empty = StringVoicing(Nil)

  def difficulty(v: StringVoicing): (Int, Int) = {
    val asNumeric = v.fingering.map {
      case OnFret(n) =>
        n
      case SkipThisString =>
        99
    }

    val min = asNumeric.min
    val max = asNumeric.max

    (max - min, min)
  }
}

case class StringVoicing(fingering: List[Fingering]) {
  def +(that: Fingering): StringVoicing =
    copy(fingering = fingering :+ that)
}
