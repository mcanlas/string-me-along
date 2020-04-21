package com.htmlism.stringmealong

object ShowVoicings extends App {
  def majorChord(note: Note) =
    List(note, note.third, note.fifth)

  def demo(instrument: StringInstrument, chord: List[Note]) =
    instrument.strings.toList.foreach { tuning =>
      val tunedString = tuning * instrument.frets

      println {
        chord.map(tunedString.fingering)
      }
    }

  demo(ukulele, majorChord(C))
  println
  demo(ukulele, majorChord(F))
  println
  demo(ukulele, majorChord(G))
  println
  demo(ukulele, majorChord(A))
}
