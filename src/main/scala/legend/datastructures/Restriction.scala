package legend.datastructures

/**
  * A trait to assist with processing of restrictions. A restriction is a logical or physical requirement that an entity must meet. The requirement can be the inclusion or exclusion of a tag, as well as a certain pool value.
  *
  * All params subject to change, work in progress.
  *
  * @todo Unify traits into a single class or create a trait interface.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
trait Restriction{
  //def meetRestriction: Boolean
}

/**
  * A restriction for pool values, uses common comparators to determine if an entity meets the restriction.
  *
  * All params subject to change, work in progress.
  *
  * @constructor A poolRestriction requires a poolName to compare against, a type of comparator in the form of a string, and a value to compare against.
  * @param poolNames A list of applicable pool names against which the restriction can be checked.
  * @param argument The comparator to use i.e. ">", "==","!=","<=", etc...
  * @param limit The value against which to compare the current pool value.
  * @todo Make pool names have a meta type to allow comparison against pool types rather than specific names.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class poolRestriction(val poolNames: List[String], val argument: String, val limit: Int) extends Restriction{
  /**
    * @param pool The pool to compare the restriction against
    * @return Returns a Boolean result indicating if the restriction was met or failed.
    */
  def meetRestriction(pool: Pool): Boolean={
    argument match{
      case ">" => pool.value > limit
      case ">=" => pool.value >= limit
      case "<" => pool.value < limit
      case "<=" => pool.value <= limit
      case "==" => pool.value == limit
      case "!=" => pool.value != limit
      case _ => true//ignore invalid restrictions
    }
}
}

/**
  * A restriction for pool values, uses common comparators to determine if an entity meets the restriction.
  *
  * All params subject to change, work in progress.
  *
  * @constructor A poolRestriction requires a poolName to compare against, a type of comparator in the form of a string, and a value to compare against.
  * @param restrictionNames A list of applicable tag group names against which the restriction can be checked.
  * @param argument The type of comparison, currently "has" or "lacks".
  * @param tagRestr The tag to checkout for the presence or absence of.
  * @todo Make pool names have a meta type to allow comparison against pool types rather than specific names.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
  case class tagRestriction(val restrictionNames: List[String], val argument: String, val tagRestr: String) extends Restriction {
  /**
    * @param tags The tags against which to check the restriction
    * @return Returns a Boolean result indicating if the restriction was met or failed.
    */
  def meetRestriction(tags: List[String]): Boolean = {
      if(argument=="has") {
        return tags.contains(tagRestr)
      }
      else if(argument=="lacks") {
        return !tags.contains(tagRestr)
      }
      else return true
    }
  }