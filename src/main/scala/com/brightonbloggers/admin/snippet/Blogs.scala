package com.brightonbloggers.admin.snippet

import scala.xml._
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.http.S
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._

import com.brightonbloggers.admin.model.Blog
import com.brightonbloggers.admin.comet.StatsServer

class Blogs {
  
  def list(xhtml: NodeSeq) : NodeSeq = {
    
    var new_url = ""
    
    def update_blog(blog: Blog, s: String) = {
      blog.url(s).save
      SetHtml("list", list(xhtml) )
    }
    
    def click_to_edit(blog: Blog) =
       swappable( <li>{blog.url}</li>,
                  ajaxText("", s => { update_blog(blog,s) }) )
    ajaxForm(
      bind("directory", xhtml, 
    		"entry" -> Blog.findAll().flatMap( blog =>
    				<li> { link("/index", () => {StatsServer ! blog  }, Text(blog.url)) } </li>
    		) )
     )
    
 
  }

}
