package legend.traits

import legend.datastructures.Point

/**
  * A trait to be extended to entities that possess a physical presence, though they may not be visible
  *
  * All params subject to change, work in progress.
  *
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
trait physical{
  var com:Point//center of mass
  var vis: Boolean = true
}
