package com.htmlism.stringmealong

object StringVoicing {
  val empty: StringVoicing = StringVoicing(Nil)

  def uniqueNotes(instrument: StringInstrument)(v: StringVoicing): Int = {
    val tunings = instrument.tunedStrings.toList.zipWithIndex

    val pitches =
      tunings.flatMap { case (s, n) =>
        val fingeringOnString = v.fingering(n)

        fingeringOnString match {
          case OnFret(n) =>
            List(s.pitches(n))
          case SkipThisString =>
            Nil
        }
      }

    pitches.map(_.note).toSet.size
  }

  def difficulty(instrument: StringInstrument)(v: StringVoicing): (Int, Int, Int) = {
    val asNumeric = v.fingering.map {
      case OnFret(n) =>
        n
      case SkipThisString =>
        99
    }

    val nonZeroMin = safeSpan(asNumeric.filter(_ != 0))(_.min)
    val nonZeroMax = safeSpan(asNumeric.filter(_ != 0))(_.max)

    val height = asNumeric.max

    (-1 * uniqueNotes(instrument)(v), nonZeroMax - nonZeroMin, height)
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
