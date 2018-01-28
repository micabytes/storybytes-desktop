package com.micabytes.storybytes

import com.micabytes.ink.InkParser
import com.micabytes.ink.Story
import com.micabytes.ink.StoryInterrupt
import com.micabytes.ink.StoryWrapper
import tornadofx.*
import java.io.InputStream

class StoryViewModel(fileName: String) : StoryWrapper, ViewModel() {
  private val story: Story

  init {
    val storyStream = getStream(fileName)
    story = InkParser.parse(storyStream, this, fileName)
    story.putVariable("world", this)
    story.next()
  }

  val size: Int
    get() = story.text.size

  fun get(i: Int) = story.text[i]

  val choiceSize: Int
    get() = story.choiceSize

  fun choice(i: Int) = story.choiceText(i)

  fun select(i: Int) {
    story.choose(i)
    story.next()
  }

  /** Used to parse and resolve tags from the Ink code programmatically.
   *  In P&T2, for instance, this is used to resolve tags such as image (place referred image on the page), clear (clear the story text), and comments
   *  (character side-comments).
   */
  override fun resolveTag(t: String) {
    TODO("not implemented")
  }

  /** Used to parse and return interrupt objects.
   * Will probably be deprecated in a future version - it's legacy code and not being used in the new version of P&T2.
   */
  override fun getInterrupt(s: String): StoryInterrupt {
    TODO("not implemented")
  }

  /** Used to retrieve story objects from the game engine.
   * This is used to return Kotlin/Java objects to the game code. The mica-ink story script treats objects as first-tier variables, and can retrieve public
   * attributes from such objects as well as run methods on them. Extremely useful if you want to avoid variable explosion.
   */
  override fun getStoryObject(objId: String): Any {
    TODO("not implemented")
  }

  /** Return an input stream for a file ID. */
  override fun getStream(fileId: String): InputStream = StoryViewModel::class.java.getResourceAsStream(fileId)

  /** Log debug messages from the mica-ink engine */
  override fun logDebug(m: String) {
    // NOOP
  }

  /** Log error messages from the mica-ink engine */
  override fun logError(m: String) {
    // NOOP
  }

  /** Log caught exceptions from the mica-ink engine. */
  override fun logException(e: Exception) {
    // NOOP
  }

}