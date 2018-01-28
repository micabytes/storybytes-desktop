package com.micabytes.storybytes

import javafx.scene.control.ScrollPane
import javafx.scene.input.MouseEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.TextFlow
import tornadofx.*

class StoryViewer : Fragment("Story Viewer") {
  private var story: StoryViewModel = StoryViewModel("/ink/cloak-of-darkness.ink")
  override val root = BorderPane()

  init {
    root.apply {
      center {
        scrollpane {
          minHeight = 720.0
          minWidth = 1024.0
          vbox {
            // Story content goes here
          }
        }
      }
    }
    update()
  }

  fun setStory(s: String) {
    story = StoryViewModel(s)
    update()
  }

  private fun update() {
    val texts: ArrayList<TextFlow> = ArrayList()
    for (i in 0 until story.size) {
      texts.add(textflow {
        text(story.get(i)) {
          font = Font(16.0)
        }
        maxWidth = 1020.0
      })
    }
    for (i in 0 until story.choiceSize) {
      texts.add(textflow {
        text(story.choice(i)) {
          fill = Color.RED
          font = Font(16.0)
        }
        maxWidth = 1020.0
        addEventHandler(MouseEvent.MOUSE_CLICKED, {
          story.select(i)
          update()
        })
      })
    }
    ((root.center as ScrollPane).content as VBox).children.clear()
    ((root.center as ScrollPane).content as VBox).children.addAll(texts)
  }

}