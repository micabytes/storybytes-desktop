package com.micabytes.storybytes

import tornadofx.*

class StoryBytesApp : App(StoryViewer::class) {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      launch<StoryBytesApp>(args)
    }
  }
}
