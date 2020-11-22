package com.htmlism.stringmealong

case class ScaleDegree(n: Int)

object ScaleDegree {
  private val roman =
    List("", "I", "II", "III", "IV", "V", "VI", "VII")

  def asRoman(deg: ScaleDegree): String =
    roman(deg.n)
}