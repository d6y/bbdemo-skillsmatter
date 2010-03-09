package com.brightonbloggers.admin.comet

import net.liftweb.actor._
import net.liftweb.http._
import net.liftweb.http.js.JsCmds._
import scala.xml._

object StatsServer extends LiftActor with ListenerManager {

  var count = 0
  
  def createUpdate = count
  
  override def lowPriority = {
    
    case b =>
      count = count + 1
      updateListeners
      
  }
  
  
}

class StatsWatcher extends CometActor with CometListenee {
  
  def registerWith = StatsServer
  
  def render = <div id="total">0</div>
  
  override def lowPriority =  {
    case c: Int =>
     partialUpdate( SetHtml("total", Text(c.toString) ) )  
    }
  
}

