# Accession Numbers
An accession number has the following format: L...LN...N (e.g. AB1234)
where L...L denotes one or more ASCII7 letters and N denotes one or more digits (0,1,2,3,4,5,6,7,8 or 9)

The utility accepts a list of accession numbers in comma separated and returns an ordered list of accession numbers where any consecutive digits N...N that share the same prefix L...L are collapsed into an accession number range. The N...N digits are left padded using 0s (e.g. 00001) and that the length of the N...N digits must be the same for accession numbers to be part of the same accession number range

Example input:
A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1

Expected output:
A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, ERR100114, ERR200000001-ERR200000003, SRR211001 

## Usage

The application can be used in 3 ways

* 


## Getting Started
These instructions will get you a copy of the project up and running on your local machine


### Prerequisites

* Java 8 JDK installed
* Maven installed

### Installing

* Unpack the project zip file and place it in any folder of preference
* In command prompt, run mnv clean install




