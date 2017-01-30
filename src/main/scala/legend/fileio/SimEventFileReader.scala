package legend.fileio

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
class SimEventFileReader {

  //todo: open file, ignore header,
  //for each line, get simevent, get number, get args
}
