package com.htmlism.stringmealong

object ShowVoicings extends App {
  def majorChord(note: Note) =
    List(note, note.third, note.fifth)

  def fingerings(tunedString: TunedString)(note: Note): List[Fingering] =
    tunedString
      .fingerings(note) match {
        case Nil =>
          List(SkipThisString)
        case xs =>
          xs.map(OnFret.apply)
      }

  def combine(vs: List[StringVoicing], fs: List[Fingering]) =
    for {
      v <- vs
      f <- fs
    } yield v + f

  def demo(instrument: StringInstrument, chord: List[Note]) = {
    val stringsWithFingerings =
      instrument.strings.toList.map { tuning =>
        val tunedString = tuning * instrument.frets

        for {
          note <- chord
          f <- fingerings(tunedString)(note)
        } yield f
      }

    val zero =
      List(StringVoicing.empty)

    stringsWithFingerings
      .foldLeft(zero)(combine)
      .map(toPrintedChord(instrument))
      .foreach(println)
  }

  def toPrintedChord(instrument: StringInstrument)(stringVoicing: StringVoicing): String =
    stringVoicing
      .fingering
      .zipWithIndex
      .map {
        case (OnFret(f), n) =>
          val pitch = (instrument.strings.toList(n) * instrument.frets).pitches(f)

          Note.spelling(pitch.note.n) + pitch.octave.n
        case (SkipThisString, _) =>
          "X"
      }.mkString(",")

  demo(ukulele, majorChord(C))
  println
  demo(ukulele, majorChord(F))
  println
  demo(ukulele, majorChord(G))
  println
  demo(ukulele, majorChord(A))
}
