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

    val nonZeroMin = safeSpan(asNumeric.filter(_ != 0))(_.min)
    val nonZeroMax = safeSpan(asNumeric.filter(_ != 0))(_.max)

    val height = asNumeric.max

    (nonZeroMax - nonZeroMin, height)
  }

  def safeSpan(xs: List[Int])(f: List[Int] => Int): Int =
    xs match {
      case Nil => 0
      case _ => f(xs)
    }
}

case class StringVoicing(fingering: List[Fingering]) {
  def +(that: Fingering): StringVoicing =
    copy(fingering = fingering :+ that)
}
