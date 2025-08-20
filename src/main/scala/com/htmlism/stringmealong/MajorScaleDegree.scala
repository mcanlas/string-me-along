package com.htmlism.stringmealong

case class MajorScaleDegree(n: Int, semitones: Int):
  def spell: String =
    val accidental =
      semitones match
        case 1  => "#"
        case 2  => "x"
        case 0  => ""
        case -1 => "b"
        case -2 => "bb"
        case _  =>
          "unknown notation"

    n.toString + accidental

object MajorScaleDegree:
  given MusicallyOrdinal[MajorScaleDegree] with
    def sharpen(x: MajorScaleDegree): MajorScaleDegree =
      x.copy(semitones = x.semitones + 1)

    def flatten(x: MajorScaleDegree): MajorScaleDegree =
      x.copy(semitones = x.semitones - 1)

  val Root: MajorScaleDegree =
    MajorScaleDegree(1, 0)
