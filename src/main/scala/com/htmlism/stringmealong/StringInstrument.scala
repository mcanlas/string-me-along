package com.htmlism.stringmealong

import cats.data.*

final case class StringInstrument(frets: Int, strings: NonEmptyList[Pitch]):
  val tunedStrings: NonEmptyList[TunedString] = strings.map(_ * frets)
