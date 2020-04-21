package com.htmlism.stringmealong

object StringVoicing {
  val empty = StringVoicing(Nil)
}

case class StringVoicing(fingering: List[Fingering]) {
  def +(that: Fingering): StringVoicing =
    copy(fingering = fingering :+ that)
}
