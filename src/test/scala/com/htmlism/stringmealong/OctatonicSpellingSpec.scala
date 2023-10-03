package com.htmlism.stringmealong

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import com.htmlism.stringmealong.syntax.*

class OctatonicSpellingSpec extends AnyFunSuite with Matchers:
  test("spell C major"):
    println:
      Scale.toPitchCollectionFrom(C.o4, Scale.MajorScale)

    println:
      HarmonicSpelling
        .spellOctatonic(OctatonicSpelling.C, C.o4, Scale.MajorScale)

    println:
      HarmonicSpelling
        .spellOctatonic(OctatonicSpelling.C, C.o4, Scale.HarmonicMinorScale)

    println:
      HarmonicSpelling
        .spellOctatonic(OctatonicSpelling.C, C.o4, Scale.NaturalMinorScale)

    println:
      HarmonicSpelling
        .spellOctatonic(OctatonicSpelling.B, B.sharp.o4, Scale.MajorScale)

    println:
      HarmonicSpelling
        .spellOctatonic(OctatonicSpelling.D, C.sharp.o4, Scale.MajorScale)
