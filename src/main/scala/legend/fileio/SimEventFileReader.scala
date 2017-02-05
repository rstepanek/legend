package legend.fileio

import legend.events.SimEvent

import scala.collection.mutable.ListBuffer
import scala.io.Source
import com.typesafe.scalalogging._
import legend.main.SimDriver
import legend.main.SimDriver._

/**
  * A class to load the SimEventFile into the simulator. A valid SimEvent file has the form "Time\tEventType\tNumber\tArg2\tArg2\tArg3\tetc..." Where Time is an valid time in miliseconds (default), seconds, minutes, hours, or days, or any valid date range. EventType is the type of event to generate i.e. Spawn, Destroy, etc... Number is the number of time the event occurrs, and the Args are the tab separated arguments of the event constructor.
  *
  * All params subject to change, work in progress.
  *
  * @author Ryan Stepanek
  * @version 0.1
  * @todo Add more functionality.
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
object SimEventFileReader extends LazyLogging{
val delimiter = '\t'

  /**
    * Load a SimEvent file and return a list of scheduled [[SimEvent]]s.
    * @param file_loc The location of the file to load.
    * @return A list of [[SimEvent]]s generated from the file.
    */
  def LoadSimEvents(file_loc:String): List[SimEvent]={
    logger.debug("Loading SimEvent file: " + file_loc)
    val fileStream = getClass.getResourceAsStream(file_loc)
    val lines = Source.fromInputStream(fileStream).getLines
    val file_args: ListBuffer[SimEvent] = new ListBuffer[SimEvent]()

      lines.foreach(line => {
        logger.debug(s"${line}")
        check_sim_event_line(line)
        val Array(time, event_type, number) = line.split(delimiter).slice(0, 3)
        val args = line.split(delimiter).slice(3, line.split(delimiter).length)

        //for(number.toInt<-0) {
        if(!(event_type.trim.toLowerCase=="event_type" | event_type.trim.toLowerCase=="eventtype"))
          file_args += SimEvent(event_type, SimDriver.system_entity, time.toLong, Some(args))
       // }
      })
    return file_args.toList
  }

  /**
    * Checks if a given line of a SimEvent file is valid and thows an error if it's not.
    * @param s The string to verify (should be a single line from the SimEvent file.
    */
  def check_sim_event_line(s:String)={
  if(!s.contains(delimiter)) throw BadlyFormattedFile("The SimEvent file is badly formatted. Separate parameters with tabs.")
}

}

/**
  * @todo Move this class to the fileio package level.
  * @param message The error message.
  */
case class BadlyFormattedFile(message: String = "") extends Exception(message)
