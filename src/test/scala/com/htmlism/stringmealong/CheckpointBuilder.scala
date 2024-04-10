package com.htmlism.stringmealong

import org.scalactic.source
import org.scalatest.Checkpoints.Checkpoint

case class CheckpointBuilder(xs: List[() => Unit] = Nil):
  def assert[A](f: => A): CheckpointBuilder =
    copy(xs = xs :+ { () =>
      val _ = f
      ()
    })

  def reportAll(using source.Position): Unit =
    xs
      .foldLeft(new Checkpoint): (cp, f) =>
        val _ =
          cp.apply(f.apply)

        cp
      .reportAll()
