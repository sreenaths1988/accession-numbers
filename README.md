# Accession Numbers
An accession number has the following format: L...LN...N (e.g. AB1234)
where L...L denotes one or more ASCII7 letters and N denotes one or more digits (0,1,2,3,4,5,6,7,8 or 9)

The utility accepts a list of accession numbers in comma separated and returns an ordered list of accession numbers where any consecutive digits N...N that share the same prefix L...L are collapsed into an accession number range. The N...N digits are left padded using 0s (e.g. 00001) and that the length of the N...N digits must be the same for accession numbers to be part of the same accession number range

Example input:
A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1

Expected output:
A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, ERR100114, ERR200000001-ERR200000003, SRR211001 

The application is build to respond to user requests through command line, web interface and REST API call. There is no need of an application server to run this application as it comes with an embedded Jetty server. Jersey is used to implement REST API feature.

## Usage

The application can be used in 3 ways

* Command Line

  	 *java -jar path-to-jar args*

	 args: Accession numbers separated with comma. Enclose in double quotes if there are spaces
      
  	 For eg: java -jar accessionnumbers-0.0.1-SNAPSHOT.jar "A00000, A0001, A0001, ERR000111, ERR000112"
 
 * Web interface
 	
 	In a command prompt, run *java jar path-to-jar* 
  	Open *project-folder/src/main/webapp/index.html* and provide input in text area and click Submit button
  
 * REST API
 
  	In a command prompt, run *java jar path-to-jar*
  	Pass data as plain/text in a REST API client to http://localhost:8080/root/accessionnumber


## Getting Started
These instructions will get you a copy of the project up and running on your local machine


### Prerequisites

* Java 8 JDK installed
* Maven installed

### Installing

* Unpack the project zip file and place it in any directory of preference
* In command prompt, run *mvn clean install*
* If build is successful, jar will be created in target directory
* Refer to Usage part to run this application


## Built With

* [Eclipse](https://eclipse.org/ide/) - IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* [Jetty](https://eclipse.org/jetty) - Embedded Server
* [Jersey](https://jersey.github.io/) - REST API implementation



