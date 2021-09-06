package com.htmlism.stringmealong

object HarmonicSpelling {
  def spellOctatonic(baseSpelling: OctatonicSpelling, root: Pitch, scale: Scale): List[String] = {
    assert(scale.intervals.length == 7)

    val pitches =
      Scale.toPitchCollectionFrom(root, scale)

    pitches.zipWithIndex
      .map { case (p, i) =>
        val baseSpellingAtDegree =
          List
            .fill(i)(())
            .foldLeft(baseSpelling)((acc, _) => acc.nextOctatonic)

        val startingTone =
          OctatonicSpelling
            .notes(baseSpellingAtDegree)

        val delta =
          p.note.n - startingTone.n

        val accidentalString =
          delta match {
            case -2 => "bb"
            case -1 | 11 => "b"
            case 0 | -12 => ""
            case 1 | -11 => "#"
            case 2 => "x"
          }

        baseSpellingAtDegree.spell + accidentalString
      }
  }
}
