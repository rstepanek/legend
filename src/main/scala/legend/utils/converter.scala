package legend.utils

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
}
