package com.brightonbloggers.admin.model

import net.liftweb.mapper._

class Blog extends LongKeyedMapper[Blog] with IdPK  {

  def getSingleton = Blog
  
  object url extends MappedString(this, 100)
  
  object title extends MappedString(this, 100)
  

}

object Blog extends Blog with LongKeyedMetaMapper[Blog]
   with CRUDify[Long, Blog]
{
  
}
