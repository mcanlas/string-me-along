package com.htmlism.stringmealong

sealed trait Fingering

final case class OnFret(n: Int) extends Fingering

case object SkipThisString extends Fingering