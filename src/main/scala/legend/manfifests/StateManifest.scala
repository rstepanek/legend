package legend.manfifests

import legend.datastructures.State
import scala.collection.mutable.Map

/**
  * This manifest tracks all states that were present in the scenario.
  * @todo Replace load_states mutable map with a concurrent map
  */
object StateManifest {

  val loaded_states = Map[String,State]()//todo:Make this a concurrency safe map

  def register_state(s:State) = {
    if(loaded_states.contains(s.name)){
      throw DuplicateStateName(s"Attempted to load at least two states with name ${s.name} all state names must be unique.")
    }
    loaded_states +=(s.name->s)
  }
}

case class DuplicateStateName(message: String = "") extends Exception(message)
