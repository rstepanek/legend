package legend.datastructures

import legend.parsers.{MissingRequiredParameterException, params}

/**
  * A class representing a process which is a collection of states. Each process must have at least on entry state and may have at least one exit state.
  *
  * All params subject to change, work in progress.
  *
  * @param name The name of the state.
  * @param cost The cost of entering a state, by default cost is charged only on state start.
  * @param yields The result of the state, what pool modification to perform when the state is exited
  * @param duration The duration of the state in sim-units (default: milliseconds)
  * @param on_start_message A string message thrown when the entity activates the state (it can only be thrown once, even if the entity enters the state several times, consecutively).
  * @param on_activation_message A string message thrown when the entity activates the state, an activation occurrs each time a state is renewed. See [[TimeFreq]]
  * @param on_hibernate_message A string message thrown when the state is toggled to void - only thrown if the state has a frequency. See [[TimeFreq]]
  * @param on_exit_message A string message thrown when the entity leaves the state (it can only be thrown once, even if the entity enters the state several times, consecutively).
  * @param cost_on_activation A boolean value, if set to true, the cost will be charged each time a state is activated. Only applies if a frequency is set. See [[TimeFreq]]
  * @param yield_on_hibernate A boolean value, if set to true, the yields will be awarded each time a state is activated. Only applies if a frequency is set. See [[TimeFreq]]
  * @param onmeta_tags A map of key:value pairs that can be searched and indexed while the state is active.
  * @param offmeta_tags A map of key:value pairs that can be searched and indexed while the state is in hibernation (void). Only applies if a frequency is set. See [[TimeFreq]]
  *
  *
  * @todo Finish this class, implement functionality through graphing library.
  * @todo Change cost to use pool types rather than specific pool names.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class State(name:String, duration:Duration,
                 timefreq:Option[TimeFreq], concurrent:Option[Boolean],
                 require_tags:Option[List[String]], banned_tags:Option[List[String]],
                 on_start_message:Option[List[String]], on_activation_message:Option[List[String]],
                 on_hibernate_message:Option[List[String]], on_exit_message:Option[List[String]],
                 onmeta_tags:Option[Map[String,String]], offmeta_tags:Option[Map[String,String]],
                 cost:Option[List[ResourceMod]], yields:Option[List[ResourceMod]],
                 cost_on_activation:Option[Boolean], yield_on_hibernate:Option[Boolean]){
 /*
  ("poolrestrictions", classOf[List[poolRestriction]]),//TODO: implement this
*/
  override def toString: String ={
    s"name: ${name}, duration: ${duration}, timefreq: ${timefreq}, concurrent: ${concurrent}, require_tags: ${require_tags}, banned_tags: ${banned_tags}, on_start_message: ${on_start_message}, on_exit_message: ${on_exit_message}, on_entrance_message: ${on_activation_message}, on_hibernate_message: ${on_hibernate_message}, onmeta_tags: ${onmeta_tags}, offmeta_tags: ${offmeta_tags}, cost: ${cost}, yields: ${yields}, cost_on_activation: ${cost_on_activation}, yield_on_hibernate: ${yield_on_hibernate}"
  }
}

/**
  * The factory/companion object for the [[State]] class. Constructs a [[State]] from a map.
  *
  */
object State {

  /**
    * This method constructs a states object from a map of param->value.
    * @param data The map of values with which to instantiate the state.
    * @return A new [[State]] object.
    */
  def apply(data:Map[String,String]): State= {
    //(data:Map[String,String]){
    /*REQUIRED PARAMS*/
    val name = params.string(data = data).get
    val duration = params.duration(data = data).get

    /*TODO:Implement required parameter check*/
    /*OPTIONAL PARAMS*/
    val timefreq = params.timefreq(data = data)
    val concurrent = params.boolean("concurrent", data)
    val require_tags = params.stringlist("require_tags", data)
    val banned_tags = params.stringlist("banned_tags", data)
    val on_start_message = params.stringlist("on_start_message", data)
    val on_exit_message = params.stringlist("on_exit_message", data)
    val on_hibernate_message = params.stringlist("on_hibernate_message", data)
    val on_activation_message = params.stringlist("on_activation_message", data)
    val onmeta_tags = params.stringmap("onmeta_tags", data)
    val offmeta_tags = params.stringmap("offmeta_tags", data)
    val cost = params.resourcemodlist("cost", data)
    val yields = params.resourcemodlist("yields", data)
    val cost_on_activation = params.boolean("cost_on_activation", data)
    val yield_on_hibernate = params.boolean("yield_on_hibernate", data)

    new State(name=name, duration=duration, timefreq=timefreq,
      concurrent=concurrent,require_tags=require_tags, banned_tags=banned_tags,
      on_start_message=on_start_message,on_exit_message=on_exit_message,
      on_hibernate_message=on_hibernate_message,on_activation_message=on_activation_message,
      onmeta_tags=onmeta_tags,offmeta_tags=offmeta_tags,
      cost=cost,yields=yields,
      cost_on_activation=cost_on_activation,yield_on_hibernate=yield_on_hibernate)
  }
}