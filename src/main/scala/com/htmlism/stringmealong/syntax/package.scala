package com.htmlism.stringmealong

import scala.annotation.tailrec

package object syntax:
  implicit class MusicallyOrdinalOps[A](x: A)(using ev: MusicallyOrdinal[A]):
    def sharp: A =
      ev.sharpen(x)

    def flat: A =
      ev.flatten(x)

    def raisedBy(int: Interval): A =
      applyN(x, ev.sharpen, int.semitones)

    def third: A =
      raisedBy(Interval.MajorThird)

    def fifth: A =
      raisedBy(Interval.PerfectFifth)

  @tailrec
  private def applyN[A](x: A, f: A => A, n: Int): A =
    if n < 1 then x
    else applyN(f(x), f, n - 1)
