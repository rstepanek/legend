package legend.datastructures

/**
  * A class representing a single point in space.
  *
  * All params subject to change, work in progress.
  *
  * @constructor Create a new pool with an initial value and (optionally) a max and min value.
  * @param x The x (longitude) coordinate of a point.
  * @param y The y (latitude) coordinate of a point.
  * @param z The z (altitude) coordinate of a point.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class Point(x:Double,y:Double,z:Double=0.0){}

/**
  * A class representing a two dimensional rectangular area in space. This is a useful construct for restraining certain pools are processes to specific geographical areas.
  *
  * All params subject to change, work in progress.
  *
  * @constructor Create a new pool with an initial value and (optionally) a max and min value.
  * @param xmin The minimum x (longitude) value of the area.
  * @param ymin The minimum y (latitude) value of the area.
  * @param xmax The maximum y (latitude) value of the area.
  * @param ymax The maximum x (longitude) value of the area.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class Area(val xmin:Double, val ymin: Double, val xmax:Double, val ymax:Double){

  def includes(p: Point): Boolean ={
    if( xmin > p.x ) return false
    if( xmax < p.x ) return false
    if( ymin > p.y ) return false
    if( ymax < p.y ) return false

    return true
  }
}