package com.micabytes.storybytes

import com.bladecoder.ink.runtime.Story
import tornadofx.*
import java.io.InputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import java.io.InputStreamReader
import java.io.BufferedReader
import java.nio.Buffer


class BladeViewModel(fileName: String) : ViewModel() {
  private val story: Story
  private val lines =  ArrayList<String>()

  val sb = StringBuilder()
  init {
    val systemResourceAsStream = ClassLoader.getSystemResourceAsStream(fileName)
    val br = BufferedReader(InputStreamReader(systemResourceAsStream, "UTF-8"))
    try {
      var line: String? = br.readLine()
      while (line != null) {
        sb.append(line)
        sb.append("\n")
        line = br.readLine()
      }
    } finally {
      br.close()
    }
    val json = sb.toString().replace('\uFEFF', ' ')
    story = Story(json)
    while (story.canContinue()) {
      lines.add(story.Continue())
    }
  }

  val size: Int
    get() = lines.size

  fun get(i: Int) = lines[i]

  val choiceSize: Int
    get() = story.currentChoices.size

  fun choice(i: Int): String = story.currentChoices[i].text

  fun select(i: Int) {
    story.chooseChoiceIndex(i)
    lines.clear()
    while (story.canContinue()) {
      lines.add(story.Continue())
    }
  }

}