package com.brightonbloggers.admin.snippet

import scala.xml.NodeSeq

class Time {

  def now(x: NodeSeq) = <span>{new java.util.Date}</span>
  
}
