package com.htmlism.stringmealong

import cats.data._

final case class StringInstrument(frets: Int, strings: NonEmptyList[Pitch])
