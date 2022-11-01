package com.htmlism.stringmealong

/**
  * Describes things that can be sharpened or flattened repeatedly
  */
trait MusicallyOrdinal[A]:
  def sharpen(x: A): A

  def flatten(x: A): A
