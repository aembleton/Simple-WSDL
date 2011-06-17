import scala.xml.XML
object Run {

  def main(args: Array[String]): Unit = {
    
    //expect an xml file name
    if (args.length == 0){
      println("You must specify a WSDL file to read in")
      System.exit(0)
    }
    
    val xml = XML.loadFile(args(0))
   
    for (element <- (xml \\ "portType" \ "operation" \ "input")) {
    	val message = (element \ "@message").text.split(":")(1)
      println(message)
    	//println((xml \\ "message" \ "@name" filter {_.text == "SetCallConvergenceRequest"}).size)
    	for(list <- xml \\ "operation" filter (s => ((s \ "@name").text == message ) )) {
    	  println(list)
    	}
    	
    	
    }

}}