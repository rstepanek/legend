package legend.utils

import scala.collection.mutable.ListBuffer

/**
  * A static class to help convert data structures as needed.
  */
object converter {

  /**
    * Takes any class, getsits declard fields and converts them into a map.
    * @see https://gist.github.com/lauris/7dc94fb29804449b1836#file-cctomap-scala
    * @param cc A class object to flatten into a map.
    * @return A map of all the vals of a class
    */
  def ccToMap(cc: AnyRef) =
    (Map[String, Any]() /: cc.getClass.getDeclaredFields) {
      (a, f) =>
        f.setAccessible(true)
        a + (f.getName -> f.get(cc))
    }

  /**
    * Split a string along several delimiters into a List[String] and trims whitespace between delimeters.
    * @param s The string to split.
    * @param delims An Array[String] containing the delimiter strings.
    * @return
    */
  def split_on_delims(s:String,delims:Array[String]): List[String]={
    var place_holder = "@@@@@@"

    val return_value:ListBuffer[String] = new ListBuffer[String]()
    var working_string = s
    for(delim<-delims){
      working_string = working_string.replaceAllLiterally(delim,place_holder)
    }
    working_string.split(place_holder).toList.map(x => x.trim)
  }
}
